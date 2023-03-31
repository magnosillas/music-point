package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basic.Music;
import br.edu.ufape.musicpoint.front.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/music")
public class MusicController {
    @Autowired
    private MusicPoint musicPoint;

    @PostMapping("cadastrarMusic")
    public Music createMusic(@RequestBody Music music){ return musicPoint.save(music); }
}
