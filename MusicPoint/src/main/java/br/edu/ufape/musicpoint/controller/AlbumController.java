package br.edu.ufape.musicpoint.controller;


import br.edu.ufape.musicpoint.basica.Album;
import br.edu.ufape.musicpoint.exceptions.AlbumNaoEncontradoException;
import br.edu.ufape.musicpoint.exceptions.ArtistaNaoEncontradoException;
import br.edu.ufape.musicpoint.fachada.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/v1/album")
public class AlbumController {
    @Autowired
    private MusicPoint musicPoint;

    @PostMapping
    public ResponseEntity<Album> criar(@RequestBody Album album){
        Album al = musicPoint.save(album);
        return new ResponseEntity<Album>(al, HttpStatus.CREATED) ;
    }

    @GetMapping("{id}")
    public ResponseEntity<Album> buscarPorId(@PathVariable long id){
        try {
            return new ResponseEntity<Album>(musicPoint.buscarAlbum(id), HttpStatus.OK);
        } catch (AlbumNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("nome/{nome}")
    public ResponseEntity<List<Album>> buscarPorNome(@PathVariable String nome){
        try {
            return new ResponseEntity<List<Album>>(musicPoint.buscarAlbumPorNome(nome), HttpStatus.OK);
        } catch (AlbumNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("lista")
    public ResponseEntity<List<Album>> buscarTodos(){
        return new ResponseEntity<List<Album>>(musicPoint.buscarTodosAlbuns(), HttpStatus.OK);
    }

    @GetMapping("artista/{artistaId}")
    public ResponseEntity<List<Album>> buscarPorArtista(@PathVariable Long artistaId){

        try {
            return new ResponseEntity<List<Album>>(musicPoint.buscarAlbumPorArtista(artistaId), HttpStatus.OK);
        } catch (ArtistaNaoEncontradoException | AlbumNaoEncontradoException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("carregar")
    public ResponseEntity carregarAlbuns(){
        musicPoint.carregarAlbuns();
        return ResponseEntity.ok(0);
    }

}
