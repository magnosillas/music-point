package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basica.Artista;
import br.edu.ufape.musicpoint.fachada.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/v1")
public class ArtistaController {
    @Autowired
    private MusicPoint musicPoint;

    @PostMapping("artista")
    public ResponseEntity<Artista> createArtist(@RequestBody Artista artista){
        Artista art = musicPoint.save(artista);
        return new ResponseEntity<Artista>(art, HttpStatus.CREATED) ;
    } 

}
