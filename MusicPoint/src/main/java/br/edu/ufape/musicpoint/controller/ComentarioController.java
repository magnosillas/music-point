package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basica.Album;
import br.edu.ufape.musicpoint.basica.Artista;
import br.edu.ufape.musicpoint.basica.Comentario;
import br.edu.ufape.musicpoint.exceptions.*;
import br.edu.ufape.musicpoint.fachada.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/v1/comentario")
public class ComentarioController {

    @Autowired
    private MusicPoint musicPoint;

    @PostMapping
    public ResponseEntity<Comentario> criar(@RequestBody Comentario comentario){
        try {
            return new ResponseEntity<Comentario>(musicPoint.save(comentario), HttpStatus.CREATED) ;
        } catch (ComentarioInvalidoException | MaxCaracteresComentarioExcedidoException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @PatchMapping
    public ResponseEntity<Comentario> atualizar(@RequestBody Comentario comentario) {
        try {
            return ResponseEntity.ok(musicPoint.atualizarComentario(comentario));
        } catch (ComentarioInvalidoException | MaxCaracteresComentarioExcedidoException e) {
            return ResponseEntity.unprocessableEntity().build();
        } catch (ComentarioNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{comentarioid}")
    public ResponseEntity<Void> deletar(@PathVariable Long comentarioid) {
        try {
            musicPoint.deletarComentario(comentarioid);
            return ResponseEntity.noContent().build();
        } catch (ComentarioNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Comentario> buscarPorId(@PathVariable Long id){
        try {
            return new ResponseEntity<Comentario>(musicPoint.buscarComentarioPorId(id), HttpStatus.OK);
        } catch (ComentarioNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("review/{postid}")
    public ResponseEntity<List<Comentario>> buscarPorPost(@PathVariable Long postid){
        try {
            return new ResponseEntity<List<Comentario>>(musicPoint.buscarComentarioPorPost(postid), HttpStatus.OK);
        } catch (ComentarioNaoEncontradoException | ReviewNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("usuario/{usuarioid}")
    public ResponseEntity<List<Comentario>> buscarPorUsuario(@PathVariable Long usuarioid){
        try {
            return new ResponseEntity<List<Comentario>>(musicPoint.buscarComentarioPorUsuario(usuarioid), HttpStatus.OK);
        } catch (ComentarioNaoEncontradoException | UsuarioNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
