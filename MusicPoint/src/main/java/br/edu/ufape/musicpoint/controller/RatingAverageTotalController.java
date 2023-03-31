package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basic.RatingAverageTotal;
import br.edu.ufape.musicpoint.front.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/rating")
public class RatingAverageTotalController {
    @Autowired
    private MusicPoint musicPoint;

    @PostMapping("cadastrarRating")
    public RatingAverageTotal createRatingAverageTotal(@RequestBody RatingAverageTotal ratingAverageTotal) { return musicPoint.save(ratingAverageTotal); }
}
