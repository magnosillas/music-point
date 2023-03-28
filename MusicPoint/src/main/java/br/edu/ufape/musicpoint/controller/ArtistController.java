package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basic.Album;
import br.edu.ufape.musicpoint.basic.Artist;
import br.edu.ufape.musicpoint.front.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/artist")
public class ArtistController {
    @Autowired
    private MusicPoint musicPoint;

    @PostMapping("CadastrarArtista")
    public Artist createArtist(@RequestBody Artist artist){
        return musicPoint.save(artist);
    }

}
