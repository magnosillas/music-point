package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basica.Artista;
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
@RequestMapping("musicpoint/api/v1/artista")
public class ArtistaController {
    @Autowired
    private MusicPoint musicPoint;

    @PostMapping
    public ResponseEntity<Artista> createArtist(@RequestBody Artista artista){
        Artista art = musicPoint.save(artista);
        return new ResponseEntity<Artista>(art, HttpStatus.CREATED) ;
    }

    @GetMapping("lista")
    public ResponseEntity<List<Artista>> buscarTodos(){
        return new ResponseEntity<List<Artista>>(musicPoint.buscarTodosArtistas(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Artista> buscarPorId(@PathVariable Long id){
        try {
            return new ResponseEntity<Artista>(musicPoint.buscarArtista(id), HttpStatus.OK);
        } catch (ArtistaNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("nome/{nome}")
    public ResponseEntity<Artista> buscarPorNome(@PathVariable String nome){
        try {
            return new ResponseEntity<Artista>(musicPoint.buscarArtistaPorNome(nome), HttpStatus.OK);
        } catch (ArtistaNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
