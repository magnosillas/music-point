package br.edu.ufape.musicpoint.fachada;

import br.edu.ufape.musicpoint.api.DeezerApi;
import br.edu.ufape.musicpoint.basica.*;
import br.edu.ufape.musicpoint.cadastro.*;
import br.edu.ufape.musicpoint.exceptions.*;
import jakarta.annotation.PostConstruct;
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
    private CadastroUsuario cadastroUsuario;
    @Autowired
    private CadastroMusica cadastroMusica;
    @Autowired
    private CadastroCadastroReview cadastroReview;
    @Autowired
    private CadastroNotaGeral cadastroNotaGeral;

    @Autowired
    private CadastroComentario cadastroComentario;



    ////////////////////// USUARIO //////////////////////////////

    public Usuario save(Usuario usuario) throws UsernameExistenteException, UsernameInvalidoException, EmailSendoUsadoException {
        return cadastroUsuario.cadastrar(usuario);
    }

    public Usuario buscarUsuario(long id)  throws UsuarioNaoEncontradoException {
        return cadastroUsuario.buscarPorId(id);
    }

    public Usuario buscarUsuario(String username) throws UsuarioNaoEncontradoException {
        return cadastroUsuario.buscarPorUsername(username);
    }

    public List<Usuario> buscarTodosUsuarios() throws UsuarioNaoEncontradoException {
        return cadastroUsuario.buscarTodos();
    }

    public Usuario atualizar (Usuario usuario) throws UsernameInvalidoException, UsernameExistenteException, UsuarioNaoEncontradoException, EmailSendoUsadoException {
        return cadastroUsuario.atualizar(usuario);
    }

    public void deletar(Usuario usuario) throws UsuarioNaoEncontradoException {
        buscarUsuario(usuario.getId());
        cadastroUsuario.deletar(usuario);
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
        return cadastroUsuario.login(email,senha);
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

    public List<Review> buscarTodosReview() throws ReviewNaoEncontradoException {
        return cadastroReview.buscarTodos();
    }

    public Review buscarReviewPorId(Long id) throws ReviewNaoEncontradoException {
        return cadastroReview.buscarPorId(id);
    }

    public List<Review> buscarReviewPorAutor(Usuario usuario) throws ReviewNaoEncontradoException {
        return cadastroReview.buscarPorAutor(usuario);
    }

    public List<Review> buscarReviewPorAutores(List<Usuario> usuarios) throws ReviewNaoEncontradoException {
        return cadastroReview.followingPosts(usuarios);
    }

    ////////////////////// ALBUM //////////////////////////////

    public Album save(Album album){
        return cadastroAlbum.cadastrarAlbum(album);
    }
    @PostConstruct
    public void carregarAlbuns(){
        DeezerApi deezerApi = new DeezerApi(this);
        try {
            if(buscarTodosAlbuns().size() == 0) {
                List<Album> albums = deezerApi.getTopAlbums();
                for (Album album : albums)
                    save(album);
                System.out.println("babaca");
                System.out.println("babaca");
                System.out.println("babaca");
                System.out.println("babaca");

            }else {
                System.out.println("Banco de dados carregado");

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public Album buscarAlbum(long id) throws AlbumNaoEncontradoException { return cadastroAlbum.procurarAlbumId(id);}

    public List<Album> buscarTodosAlbuns() throws AlbumNaoEncontradoException {
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
    public List<Artista> buscarTodosArtistas() throws ArtistaNaoEncontradoException {
        return cadastroArtista.buscarTodos();
    }

    public Artista buscarArtista(Long id) throws ArtistaNaoEncontradoException {
        return cadastroArtista.buscarPorId(id);
    }

    public Artista buscarArtistaPorNome(String nome) throws ArtistaNaoEncontradoException {
        return cadastroArtista.buscarPorNome(nome);
    }


    ////////////////////// MUSICA //////////////////////////////
    public Musica save(Musica musica) { return cadastroMusica.cadastrarMusica(musica); }
    public List<Musica> buscarTodasMusicas() throws MusicaNaoEncontradaException {return cadastroMusica.buscarTodos();}
    public Musica buscarMusicaPorId(Long id) throws MusicaNaoEncontradaException {
        return cadastroMusica.buscarPorId(id);
    }

    public Musica buscarMusicaPorNome(String nome) throws MusicaNaoEncontradaException {
        return cadastroMusica.buscarPorNome(nome);
    }

    ////////////////////// NOTA GERAL //////////////////////////////

    public NotalGeral save(NotalGeral notalGeralTotal) { return cadastroNotaGeral.cadastrarMediaNotas(notalGeralTotal); }


    ////////////////////// NOTA GERAL //////////////////////////////

    public Comentario save(Comentario comentario) throws ComentarioInvalidoException, MaxCaracteresComentarioExcedidoException {
        return cadastroComentario.cadastrar(comentario);
    }

    public List<Comentario> buscarComentarioPorPost(Long reviewid) throws ComentarioNaoEncontradoException, ReviewNaoEncontradoException {
        return cadastroComentario.buscarPeloPost(buscarReviewPorId(reviewid));
    }

    public List<Comentario> buscarComentarioPorUsuario(Long usuarioId) throws UsuarioNaoEncontradoException, ComentarioNaoEncontradoException {
        return cadastroComentario.buscarPeloAutor(buscarUsuario(usuarioId));
    }

    public Comentario buscarComentarioPorId(Long id) throws ComentarioNaoEncontradoException {
        return cadastroComentario.buscarPorId(id);
    }

    public Comentario atualizarComentario(Comentario comentario) throws ComentarioInvalidoException, MaxCaracteresComentarioExcedidoException, ComentarioNaoEncontradoException {
        return cadastroComentario.atualizar(comentario);
    }

    public void deletarComentario (Long id) throws ComentarioNaoEncontradoException {
        cadastroComentario.deletar(buscarComentarioPorId(id));
    }
}
