package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basica.Musica;
import br.edu.ufape.musicpoint.fachada.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/v1/musica")
public class MusicaController {
    @Autowired
    private MusicPoint musicPoint;

    @PostMapping
    public ResponseEntity<Musica> createMusic(@RequestBody Musica musica) {
        Musica msc = musicPoint.save(musica);
        return new ResponseEntity<Musica>(msc, HttpStatus.CREATED);
    }


}
