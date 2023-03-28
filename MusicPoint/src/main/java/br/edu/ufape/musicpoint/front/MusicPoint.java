package br.edu.ufape.musicpoint.front;

import br.edu.ufape.musicpoint.basic.*;
import br.edu.ufape.musicpoint.register.CadastroAlbum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicPoint {
    @Autowired
    private CadastroAlbum cadastroAlbum;

    public Album save(Album album){
        return cadastroAlbum.save(album);
    }
}
