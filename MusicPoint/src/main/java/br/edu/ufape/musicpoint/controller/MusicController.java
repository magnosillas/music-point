package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basica.Music;
import br.edu.ufape.musicpoint.fachada.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/")
public class MusicController {
    @Autowired
    private MusicPoint musicPoint;

    @PostMapping("music")
    public Music createMusic(@RequestBody Music music){ return musicPoint.save(music); }
}
