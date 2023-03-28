package br.edu.ufape.musicpoint.front;

import br.edu.ufape.musicpoint.basic.*;
import br.edu.ufape.musicpoint.register.CadastroAlbum;
import br.edu.ufape.musicpoint.register.RegisterArtist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicPoint {
    @Autowired
    private CadastroAlbum cadastroAlbum;
    private RegisterArtist registerArtist;

    public Album save(Album album){
        return cadastroAlbum.save(album);
    }
    public Artist save(Artist artist) { return registerArtist.save(artist);}
}
