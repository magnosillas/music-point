package br.edu.ufape.musicpoint.controller;

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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/v1")
public class ReviewController {
    @Autowired
    private MusicPoint musicPoint;

    @PostMapping("review")
    public ResponseEntity<Review> createReview(@RequestBody Review review) throws TextoReviewInvalidoException, MaxCaracteresReviewExcedidoException, NomeReviewInvalidoException {
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

    @PatchMapping("like")
    public ResponseEntity<Void> like (@RequestBody Review review) {
        try {
            musicPoint.likePost(review);
            return ResponseEntity.noContent().build();
        } catch (ReviewNaoEncontradoException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("unlike")
    public ResponseEntity<Void> unlike (@RequestBody Review review) {
        try {
            musicPoint.unlikePost(review);
            return ResponseEntity.noContent().build();
        } catch (ReviewNaoEncontradoException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
