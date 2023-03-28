package br.edu.ufape.musicpoint.controller;


import br.edu.ufape.musicpoint.basica.Album;
import br.edu.ufape.musicpoint.fachada.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/v1")
public class AlbumController {
    @Autowired
    private MusicPoint musicPoint;

    @PostMapping("cadastrarAlbum")
    public Album createAlbum(@RequestBody Album album){
        return musicPoint.save(album);
    }

}
