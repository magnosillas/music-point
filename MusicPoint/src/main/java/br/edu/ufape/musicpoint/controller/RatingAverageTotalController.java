package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basica.RatingAverageTotal;
import br.edu.ufape.musicpoint.fachada.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/")
public class RatingAverageTotalController {
    @Autowired
    private MusicPoint musicPoint;

    @PostMapping("rating")
    public RatingAverageTotal createRatingAverageTotal(@RequestBody RatingAverageTotal ratingAverageTotal) { return musicPoint.save(ratingAverageTotal); }
}
