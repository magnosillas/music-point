package br.edu.ufape.musicpoint.front;

import br.edu.ufape.musicpoint.basic.*;
import br.edu.ufape.musicpoint.register.RegisterAlbum;
import br.edu.ufape.musicpoint.register.RegisterArtist;
import br.edu.ufape.musicpoint.register.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicPoint {
    @Autowired
    private RegisterAlbum registerAlbum;
    private RegisterArtist registerArtist;
    private RegisterUser registerUser;

    public Album save(Album album){
        return registerAlbum.save(album);
    }
    public Artist save(Artist artist) {
        return registerArtist.save(artist);
    }
    public User save(User user) {
        return registerUser.save(user);
    }
}
