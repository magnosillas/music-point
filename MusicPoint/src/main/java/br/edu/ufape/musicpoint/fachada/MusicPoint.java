package br.edu.ufape.musicpoint.fachada;

import br.edu.ufape.musicpoint.basica.*;
import br.edu.ufape.musicpoint.cadastro.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public Album save(Album album){
        return cadastroAlbum.cadastrarAlbum(album);
    }
    public Artista save(Artista artista) {
        return cadastroArtista.cadastrarArtista(artista);
    }
    public Usuario save(Usuario usuario) {
        return registerUser.cadastrar(usuario);
    }
    public Musica save(Musica musica) { return cadastroMusica.cadastrarMusica(musica); }
    public Review save(Review review) { return cadastroReview.cadastrar(review); }
    public NotalGeral save(NotalGeral notalGeralTotal) { return cadastroNotaGeral.cadastrarMediaNotas(notalGeralTotal); }

    public Album procurarAlbumId(long id){ return cadastroAlbum.procurarAlbumId(id);}
    public Usuario procurarUsuario(long id)
//            throws UsuarioNaoEncontradoException
    {return registerUser.buscarPorId(id);}

    public Usuario procurarUsuario(String username)
//            throws UsuarioNaoEncontradoException
    {return registerUser.buscarPorUsername(username);}

    public Usuario atualizar (Usuario usuario)
//        throws UsernameInvalidoException, UsernameExistenteException,UsuarioNaoEncontradoException
    {
        return registerUser.atualizar(usuario);
    }

    public void seguirUsuario(Usuario usuario, Usuario seguindo)
//            throws UserAlreadyFollowedException, UserNotFoundException, UsernameTakenException, InvalidUsernameException
    {
        if (usuario.seguir(seguindo)) {
            seguindo.setSeguidores(seguindo.getSeguidores() + 1);
            atualizar(usuario);
            atualizar(seguindo);
        }
    }

    public void seguirUsuario(Long usuarioId, Long seguindoId)
            throws UserNotFoundException, UserAlreadyFollowedException
    {
        try {
            followUser(findUser(usuarioId), findUser(seguindoId));
        } catch (UsernameTakenException | InvalidUsernameException e) {
            throw new RuntimeException(e);
        }
    }

    public void seguirUsuario(String followingUsername, String followedUsername) throws UserNotFoundException, UserAlreadyFollowedException {
        try {
            followUser(findUser(followingUsername), findUser(followedUsername));
        } catch (UsernameTakenException | InvalidUsernameException e) {
            throw new RuntimeException(e);
        }
    }

    public void pararSeguirUsuario(User following, User followed) throws UserNotFoundException, UsernameTakenException, InvalidUsernameException, UserNotFollowedException {
        if (following.unfollow(followed)) {
            followed.setFollowers(followed.getFollowers() - 1);
            updateUser(following);
            updateUser(followed);
        }
    }

    public void pararSeguirUsuario(Long followingId, Long followedId) throws UserNotFoundException, UserNotFollowedException {
        try {
            unfollowUser(findUser(followingId), findUser(followedId));
        } catch (UsernameTakenException | InvalidUsernameException e) {
            throw new RuntimeException(e);
        }
    }

    public void pararSeguirUsuario(String followingUsername, String followedUsername) throws UserNotFoundException, UserNotFollowedException {
        try {
            unfollowUser(findUser(followingUsername), findUser(followedUsername));
        } catch (UsernameTakenException | InvalidUsernameException e) {
            throw new RuntimeException(e);
        }
    }


}
