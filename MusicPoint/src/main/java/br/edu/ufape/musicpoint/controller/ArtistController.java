package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basica.Artist;
import br.edu.ufape.musicpoint.fachada.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/")
public class ArtistController {
    @Autowired
    private MusicPoint musicPoint;

    @PostMapping("artista")
    public Artist createArtist(@RequestBody Artist artist){
        return musicPoint.save(artist);
    }

}
