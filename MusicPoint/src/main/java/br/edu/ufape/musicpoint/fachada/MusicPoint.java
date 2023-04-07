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
    private RegisterRatingAverageTotal registerRatingAverageTotal;
    @Autowired
    private RegisterPostReview registerPostReview;


    public Album save(Album album){
        return registerAlbum.cadastrarAlbum(album);
    }
    public Artist save(Artist artist) {
        return registerArtist.save(artist);
    }
    public User save(User user) {
        return registerUser.save(user);
    }
    public Music save(Music music) { return registerMusic.save(music); }
    public Review save(Review review) { return registerReview.save(review); }
    public RatingAverageTotal save(RatingAverageTotal ratingAverageTotal) { return registerRatingAverageTotal.save(ratingAverageTotal); }
    public PostReview save(PostReview postReview) { return registerPostReview.save(postReview); }

    public Album procurarAlbumId(long id){ return registerAlbum.procurarAlbumId(id);}

}
