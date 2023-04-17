package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basica.Album;
import br.edu.ufape.musicpoint.basica.Artista;
import br.edu.ufape.musicpoint.basica.Musica;
import br.edu.ufape.musicpoint.exceptions.ArtistaNaoEncontradoException;
import br.edu.ufape.musicpoint.exceptions.MusicaNaoEncontradaException;
import br.edu.ufape.musicpoint.fachada.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("lista")
    public ResponseEntity<List<Musica>> buscarTodos(){
        try {
            return new ResponseEntity<List<Musica>>(musicPoint.buscarTodasMusicas(), HttpStatus.OK);
        } catch (MusicaNaoEncontradaException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("nome/{nome}")
    public ResponseEntity<Musica> buscarPorNome(@PathVariable String nome){
        try {
            return new ResponseEntity<Musica>(musicPoint.buscarMusicaPorNome(nome), HttpStatus.OK);
        } catch (MusicaNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Musica> buscaPorId(@PathVariable Long id){
        try {
            return new ResponseEntity<Musica>(musicPoint.buscarMusicaPorId(id), HttpStatus.OK);
        } catch (MusicaNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
