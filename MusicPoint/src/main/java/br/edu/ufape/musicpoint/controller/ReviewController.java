package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basica.Artista;
import br.edu.ufape.musicpoint.basica.Review;
import br.edu.ufape.musicpoint.basica.Usuario;
import br.edu.ufape.musicpoint.exceptions.*;
import br.edu.ufape.musicpoint.fachada.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/v1/review")
public class ReviewController {
    @Autowired
    private MusicPoint musicPoint;

    @PostMapping
    public ResponseEntity<Review> criar(@RequestBody Review review) throws TextoReviewInvalidoException, MaxCaracteresReviewExcedidoException, NomeReviewInvalidoException {
        Review rvw = musicPoint.save(review);
        return new ResponseEntity<Review>(rvw, HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Review> atualizar(@RequestBody Review review) {
        try {
            return ResponseEntity.ok(musicPoint.atualizarReview(review));
        } catch (ReviewNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        } catch (NomeReviewInvalidoException | TextoReviewInvalidoException | MaxCaracteresReviewExcedidoException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @GetMapping("lista")
    public ResponseEntity<List<Review>> buscarTodos()  {
        try {
            return new ResponseEntity<List<Review>>(musicPoint.buscarTodosReview(), HttpStatus.OK);
        } catch (ReviewNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("usuario")
    public ResponseEntity<List<Review>> buscarPorUsuario(@RequestBody Usuario usuario)  {
        try {
            return new ResponseEntity<List<Review>>(musicPoint.buscarReviewPorAutor(usuario), HttpStatus.OK);
        } catch (ReviewNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("autores")
    public ResponseEntity<List<Review>> buscarPorAutores(@RequestBody List<Usuario> usuarios)  {
        try {
            return new ResponseEntity<List<Review>>(musicPoint.buscarReviewPorAutores(usuarios), HttpStatus.OK);
        } catch (ReviewNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }



    @PatchMapping("like/{reviewId}")
    public ResponseEntity<Review> like (@PathVariable Long reviewId) {
        try {
            return ResponseEntity.ok(musicPoint.likePost(reviewId));
        } catch (ReviewNaoEncontradoException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Review> buscarPorId(@PathVariable Long id){
        try {
            return new ResponseEntity<Review>(musicPoint.buscarReviewPorId(id), HttpStatus.OK);
        } catch (ReviewNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("unlike/{reviewId}")
    public ResponseEntity<Review> unlike (@PathVariable Long reviewId) {
        try {
            return ResponseEntity.ok(musicPoint.unlikePost(reviewId));
        } catch (ReviewNaoEncontradoException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
