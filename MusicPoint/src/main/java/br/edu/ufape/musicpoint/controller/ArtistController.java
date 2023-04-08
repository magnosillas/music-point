package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basica.Album;
import br.edu.ufape.musicpoint.basica.Artist;
import br.edu.ufape.musicpoint.fachada.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/v1")
public class ArtistController {
    @Autowired
    private MusicPoint musicPoint;

    @PostMapping("artista")
    public ResponseEntity<Artist> createArtist(@RequestBody Artist artist){
        Artist art = musicPoint.save(artist);
        return new ResponseEntity<Artist>(art, HttpStatus.CREATED) ;
    } 

}
