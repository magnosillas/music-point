package br.edu.ufape.musicpoint.controller;


import br.edu.ufape.musicpoint.basica.Album;
import br.edu.ufape.musicpoint.fachada.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/v1/album")
public class AlbumController {
    @Autowired
    private MusicPoint musicPoint;

    @PostMapping
    public ResponseEntity<Album> createAlbum(@RequestBody Album album){
        Album al = musicPoint.save(album);
        return new ResponseEntity<Album>(al, HttpStatus.CREATED) ;
    }

    @GetMapping("{id}")
    public ResponseEntity<Album> findByIdAlbum(@PathVariable long id){
        if (musicPoint.bsucarAlbum(id) != null) {
            return new ResponseEntity<Album>(musicPoint.bsucarAlbum(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<Album>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("carregar")
    public ResponseEntity carregarAlbuns(){
        musicPoint.carregarAlbuns();
        return ResponseEntity.ok(0);
    }

}
