package br.edu.ufape.musicpoint.fachada;

import br.edu.ufape.musicpoint.basica.*;
import br.edu.ufape.musicpoint.cadastro.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicPoint {
    @Autowired
    private RegisterAlbum registerAlbum;
    @Autowired
    private RegisterArtist registerArtist;
    @Autowired
    private CadastroUsuario registerUser;
    @Autowired
    private RegisterMusic registerMusic;
    @Autowired
    private RegisterReview registerReview;
    @Autowired
    private RegisterRatingAverage registerRatingAverage;


    public Album save(Album album){
        return registerAlbum.cadastrarAlbum(album);
    }
    public Artist save(Artist artist) {
        return registerArtist.cadastrarArtista(artist);
    }
    public User save(User user) {
        return registerUser.cadastrarUsuario(user);
    }
    public Music save(Music music) { return registerMusic.cadastrarMusica(music); }
    public Review save(Review review) { return registerReview.cadastrarReview(review); }
    public RatingAverage save(RatingAverage ratingAverageTotal) { return registerRatingAverage.cadastrarMediaNotas(ratingAverageTotal); }

    public Album procurarAlbumId(long id){ return registerAlbum.procurarAlbumId(id);}
    public User procurarUserId(long id){return registerUser.procurarIdUsuario(id);}

}
