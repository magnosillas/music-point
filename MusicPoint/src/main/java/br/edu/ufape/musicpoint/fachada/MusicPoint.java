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
        return registerUser.cadastrarUsuario(usuario);
    }
    public Musica save(Musica musica) { return cadastroMusica.cadastrarMusica(musica); }
    public Review save(Review review) { return cadastroReview.cadastrar(review); }
    public NotalGeral save(NotalGeral notalGeralTotal) { return cadastroNotaGeral.cadastrarMediaNotas(notalGeralTotal); }

    public Album procurarAlbumId(long id){ return cadastroAlbum.procurarAlbumId(id);}
    public Usuario procurarUserId(long id){return registerUser.procurarIdUsuario(id);}

}
