package br.edu.ufape.musicpoint.fachada;

import br.edu.ufape.musicpoint.api.DeezerApi;
import br.edu.ufape.musicpoint.basica.*;
import br.edu.ufape.musicpoint.cadastro.*;
import br.edu.ufape.musicpoint.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicPoint {
    @Autowired
    private CadastroAlbum cadastroAlbum;
    @Autowired
    private CadastroArtista cadastroArtista;
    @Autowired
    private CadastroUsuario registerUser;
    @Autowired
    private CadastroMusica cadastroMusica;
    @Autowired
    private CadastroReview cadastroReview;
    @Autowired
    private CadastroNotaGeral cadastroNotaGeral;

    ////////////////////// USUARIO //////////////////////////////

    public Usuario save(Usuario usuario) throws UsernameExistenteException, UsernameInvalidoException, EmailSendoUsadoException {
        return registerUser.cadastrar(usuario);
    }

    public Usuario buscarUsuario(long id)  throws UsuarioNaoEncontradoException {
        return registerUser.buscarPorId(id);
    }

    public Usuario buscarUsuario(String username) throws UsuarioNaoEncontradoException {
        return registerUser.buscarPorUsername(username);
    }

    public List<Usuario> buscarTodosUsuarios(){
        return registerUser.buscarTodos();
    }

    public Usuario atualizar (Usuario usuario) throws UsernameInvalidoException, UsernameExistenteException, UsuarioNaoEncontradoException, EmailSendoUsadoException {
        return registerUser.atualizar(usuario);
    }

    public void deletar(Usuario usuario) throws UsuarioNaoEncontradoException {
        buscarUsuario(usuario.getId());
        registerUser.deletar(usuario);
    }

    public void deletar(Long usuarioId) throws UsuarioNaoEncontradoException{
        deletar(buscarUsuario(usuarioId));
    }

    public void deletar(String username) throws UsuarioNaoEncontradoException{
        deletar(buscarUsuario(username));
    }

    public Usuario seguirUsuario(Usuario usuario, Usuario seguindo) throws UsuarioJaSeguidoException, UsuarioNaoEncontradoException, UsernameExistenteException, UsernameInvalidoException, EmailSendoUsadoException {
        if (usuario.seguir(seguindo)) {
            seguindo.setSeguidores(seguindo.getSeguidores() + 1);
            atualizar(usuario);
            atualizar(seguindo);

        }
        return usuario;
    }

    public Usuario seguirUsuario(Long usuarioId, Long seguindoId) throws UsuarioNaoEncontradoException, UsuarioJaSeguidoException  {
        try {
            return seguirUsuario(buscarUsuario(usuarioId), buscarUsuario(seguindoId));
        } catch (UsernameExistenteException | UsernameInvalidoException | EmailSendoUsadoException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario seguirUsuario(String usuarioUsername, String seguindoUsername) throws UsuarioNaoEncontradoException, UsuarioJaSeguidoException {
        try {
            return seguirUsuario(buscarUsuario(usuarioUsername), buscarUsuario(seguindoUsername));
        } catch (UsernameExistenteException | UsernameInvalidoException | EmailSendoUsadoException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario pararSeguirUsuario(Usuario usuario, Usuario seguindo) throws UsuarioNaoEncontradoException, UsernameExistenteException, UsernameInvalidoException, UsuarioNaoSeguidoException, EmailSendoUsadoException {
        if (usuario.pararSeguir(seguindo)) {
            seguindo.setSeguidores(seguindo.getSeguidores() - 1);
            atualizar(usuario);
            atualizar(seguindo);

        }
        return usuario;
    }

    public Usuario pararSeguirUsuario(Long followingId, Long followedId) throws UsuarioNaoEncontradoException, UsuarioNaoSeguidoException {
        try {
            return pararSeguirUsuario(buscarUsuario(followingId), buscarUsuario(followedId));
        } catch (UsernameExistenteException | UsernameInvalidoException | EmailSendoUsadoException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario pararSeguirUsuario(String usuarioUsername, String seguindoUsername) throws UsuarioNaoEncontradoException, UsuarioNaoSeguidoException {
        try {
            return pararSeguirUsuario(buscarUsuario(usuarioUsername), buscarUsuario(seguindoUsername));
        } catch (UsernameExistenteException | UsernameInvalidoException | EmailSendoUsadoException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario login(String email, String senha) throws UsuarioNaoEncontradoException, SenhaIncorretaException {
        return registerUser.login(email,senha);
    }


    ////////////////////// REVIEW //////////////////////////////

    public Review save(Review review) throws TextoReviewInvalidoException, MaxCaracteresReviewExcedidoException, NomeReviewInvalidoException { return cadastroReview.cadastrar(review); }

    public Review atualizarReview(Review review) throws ReviewNaoEncontradoException, TextoReviewInvalidoException, NomeReviewInvalidoException, MaxCaracteresReviewExcedidoException{
        return cadastroReview.atualizar(review);
    }

    public Review likePost(Long reviewId) throws ReviewNaoEncontradoException {
        Review review = cadastroReview.buscarPorId(reviewId);
        review.like();
        try {
            atualizarReview(review);
            return review;
        } catch (NomeReviewInvalidoException | TextoReviewInvalidoException | MaxCaracteresReviewExcedidoException e) {
            throw new RuntimeException(e);
        }
    }

    public Review unlikePost(Long reviewId) throws ReviewNaoEncontradoException {
        Review review = cadastroReview.buscarPorId(reviewId);
        review.unlike();
        try {
            atualizarReview(review);
            return review;
        } catch (NomeReviewInvalidoException | TextoReviewInvalidoException | MaxCaracteresReviewExcedidoException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Review> buscarTodosReview(){
        return cadastroReview.buscarTodos();
    }

    ////////////////////// ALBUM //////////////////////////////

    public Album save(Album album){
        return cadastroAlbum.cadastrarAlbum(album);
    }

    public void carregarAlbuns(){
        DeezerApi deezerApi = new DeezerApi(this);
        try {
            List<Album> albums = deezerApi.getTopAlbums();
            for(Album album : albums)
                save(album);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Album buscarAlbum(long id) throws AlbumNaoEncontradoException { return cadastroAlbum.procurarAlbumId(id);}

    public List<Album> buscarTodosAlbuns(){
        return cadastroAlbum.buscarTodos();
    }

    public List<Album> buscarAlbumPorArtista(Artista artista) throws AlbumNaoEncontradoException {
        return cadastroAlbum.buscarPorArtista(artista);
    }
    public List<Album> buscarAlbumPorNome(String nome) throws AlbumNaoEncontradoException {
        return cadastroAlbum.buscarPorNome(nome);
    }
    public List<Album> buscarAlbumPorArtista(Long artistaId) throws ArtistaNaoEncontradoException, AlbumNaoEncontradoException {
        return buscarAlbumPorArtista(buscarArtista(artistaId));
    }

    ////////////////////// ARTISTA //////////////////////////////
    public Artista save(Artista artista) {
        return cadastroArtista.cadastrarArtista(artista);
    }
    public List<Artista> buscarTodosArtistas(){
        return cadastroArtista.buscarTodos();
    }

    public Artista buscarArtista(Long id) throws ArtistaNaoEncontradoException {
        return cadastroArtista.buscarPorId(id);
    }

    public List<Artista> buscarArtistaPorNome(String nome) throws ArtistaNaoEncontradoException {
        return cadastroArtista.buscarPorNome(nome);
    }


    ////////////////////// MUSICA //////////////////////////////
    public Musica save(Musica musica) { return cadastroMusica.cadastrarMusica(musica); }
    public List<Musica> buscarTodasMusicas(){return cadastroMusica.buscarTodos();}

    ////////////////////// NOTA GERAL //////////////////////////////

    public NotalGeral save(NotalGeral notalGeralTotal) { return cadastroNotaGeral.cadastrarMediaNotas(notalGeralTotal); }





}
