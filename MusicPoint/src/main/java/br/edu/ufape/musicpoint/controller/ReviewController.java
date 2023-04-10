package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basica.Review;
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
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review rvw = musicPoint.save(review);
        return new ResponseEntity<Review>(rvw, HttpStatus.CREATED);
    }
}
