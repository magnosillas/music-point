package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basica.Review;
import br.edu.ufape.musicpoint.fachada.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/")
public class ReviewController {
    @Autowired
    private MusicPoint musicPoint;

    @PostMapping("review")
    public Review createReview(@RequestBody Review review) { return musicPoint.save(review); }
}
