package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basica.Artist;
import br.edu.ufape.musicpoint.basica.Music;
import br.edu.ufape.musicpoint.fachada.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/v1")
public class MusicController {
    @Autowired
    private MusicPoint musicPoint;

    @PostMapping("musica")
    public ResponseEntity<Music> createMusic(@RequestBody Music music) {
        Music msc = musicPoint.save(music);
        return new ResponseEntity<Music>(msc, HttpStatus.CREATED);
    }


}
