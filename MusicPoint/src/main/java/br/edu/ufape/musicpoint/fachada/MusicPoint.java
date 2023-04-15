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

    public Album save(Album album){
        return cadastroAlbum.cadastrarAlbum(album);
    }
    public Artista save(Artista artista) {
        return cadastroArtista.cadastrarArtista(artista);
    }
    public Usuario save(Usuario usuario) throws UsernameExistenteException, UsernameInvalidoException {
        return registerUser.cadastrar(usuario);
    }
    public Musica save(Musica musica) { return cadastroMusica.cadastrarMusica(musica); }
    public Review save(Review review) throws TextoReviewInvalidoException, MaxCaracteresReviewExcedidoException, NomeReviewInvalidoException { return cadastroReview.cadastrar(review); }
    public NotalGeral save(NotalGeral notalGeralTotal) { return cadastroNotaGeral.cadastrarMediaNotas(notalGeralTotal); }

    public Album bsucarAlbum(long id){ return cadastroAlbum.procurarAlbumId(id);}
    public Usuario buscarUsuario(long id)  throws UsuarioNaoEncontradoException {
        return registerUser.buscarPorId(id);}

    public Usuario buscarUsuario(String username) throws UsuarioNaoEncontradoException {
        return registerUser.buscarPorUsername(username);
    }

    public Usuario atualizar (Usuario usuario) throws UsernameInvalidoException, UsernameExistenteException,UsuarioNaoEncontradoException
    {
        return registerUser.atualizar(usuario);
    }

    public void deletar(Usuario usuario) throws UsuarioNaoEncontradoException {
        buscarUsuario(usuario.getId());
        registerUser.deletar(usuario);
    }

    public void deletar(Long usuarioId) throws UsuarioNaoEncontradoException{
        deletar(buscarUsuario(usuarioId));
    }

    public Usuario seguirUsuario(Usuario usuario, Usuario seguindo) throws UsuarioJaSeguidoException, UsuarioNaoEncontradoException, UsernameExistenteException, UsernameInvalidoException
    {
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
        } catch (UsernameExistenteException | UsernameInvalidoException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario seguirUsuario(String usuarioUsername, String seguindoUsername) throws UsuarioNaoEncontradoException, UsuarioJaSeguidoException {
        try {
            return seguirUsuario(buscarUsuario(usuarioUsername), buscarUsuario(seguindoUsername));
        } catch (UsernameExistenteException | UsernameInvalidoException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario pararSeguirUsuario(Usuario usuario, Usuario seguindo) throws UsuarioNaoEncontradoException, UsernameExistenteException, UsernameInvalidoException, UsuarioNaoSeguidoException {
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
        } catch (UsernameExistenteException | UsernameInvalidoException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario pararSeguirUsuario(String usuarioUsername, String seguindoUsername) throws UsuarioNaoEncontradoException, UsuarioNaoSeguidoException {
        try {
            return pararSeguirUsuario(buscarUsuario(usuarioUsername), buscarUsuario(seguindoUsername));
        } catch (UsernameExistenteException | UsernameInvalidoException e) {
            throw new RuntimeException(e);
        }
    }

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

}
