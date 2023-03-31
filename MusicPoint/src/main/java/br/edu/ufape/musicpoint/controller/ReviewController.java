package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basic.Review;
import br.edu.ufape.musicpoint.front.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/review")
public class ReviewController {
    @Autowired
    private MusicPoint musicPoint;

    @PostMapping("cadastrarReview")
    public Review createReview(@RequestBody Review review) { return musicPoint.save(review); }
}
