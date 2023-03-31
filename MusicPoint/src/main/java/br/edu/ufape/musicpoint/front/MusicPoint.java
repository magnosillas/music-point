package br.edu.ufape.musicpoint.front;

import br.edu.ufape.musicpoint.basic.*;
import br.edu.ufape.musicpoint.register.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicPoint {
    @Autowired
    private RegisterAlbum registerAlbum;
    private RegisterArtist registerArtist;
    private RegisterUser registerUser;
    private RegisterFriend registerFriend;
    private RegisterMusic registerMusic;
    private RegisterReview registerReview;
    private RegisterRatingAverageTotal registerRatingAverageTotal;
    private RegisterPostReview registerPostReview;

    public Album save(Album album){
        return registerAlbum.save(album);
    }
    public Artist save(Artist artist) {
        return registerArtist.save(artist);
    }
    public User save(User user) {
        return registerUser.save(user);
    }
    public Friend save(Friend friend) { return registerFriend.save(friend); }
    public Music save(Music music) { return registerMusic.save(music); }
    public Review save(Review review) { return registerReview.save(review); }
    public RatingAverageTotal save(RatingAverageTotal ratingAverageTotal) { return registerRatingAverageTotal.save(ratingAverageTotal); }
    public PostReview save(PostReview postReview) { return registerPostReview.save(postReview); }
}
