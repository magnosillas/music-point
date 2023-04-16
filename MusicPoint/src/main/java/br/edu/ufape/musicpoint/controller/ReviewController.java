package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basica.Album;
import br.edu.ufape.musicpoint.basica.Review;
import br.edu.ufape.musicpoint.exceptions.MaxCaracteresReviewExcedidoException;
import br.edu.ufape.musicpoint.exceptions.NomeReviewInvalidoException;
import br.edu.ufape.musicpoint.exceptions.ReviewNaoEncontradoException;
import br.edu.ufape.musicpoint.exceptions.TextoReviewInvalidoException;
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
    public ResponseEntity<Review> criarReview(@RequestBody Review review) throws TextoReviewInvalidoException, MaxCaracteresReviewExcedidoException, NomeReviewInvalidoException {
        Review rvw = musicPoint.save(review);
        return new ResponseEntity<Review>(rvw, HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Review> atualizarReview(@RequestBody Review review) {
        try {
            return ResponseEntity.ok(musicPoint.atualizarReview(review));
        } catch (ReviewNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        } catch (NomeReviewInvalidoException | TextoReviewInvalidoException | MaxCaracteresReviewExcedidoException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @GetMapping("lista")
    public ResponseEntity<List<Review>> buscarTodos(){
        return new ResponseEntity<List<Review>>(musicPoint.buscarTodosReview(), HttpStatus.OK);
    }

    @PatchMapping("like/{reviewId}")
    public ResponseEntity<Review> like (@PathVariable Long reviewId) {
        try {
            return ResponseEntity.ok(musicPoint.likePost(reviewId));
        } catch (ReviewNaoEncontradoException ex) {
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
