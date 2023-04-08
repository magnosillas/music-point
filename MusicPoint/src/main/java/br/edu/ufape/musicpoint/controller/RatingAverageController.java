package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basica.Music;
import br.edu.ufape.musicpoint.basica.RatingAverage;
import br.edu.ufape.musicpoint.fachada.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/v1")
public class RatingAverageController {
    @Autowired
    private MusicPoint musicPoint;

    @PostMapping("rating")
    public ResponseEntity<RatingAverage> createRatingAverage(@RequestBody RatingAverage rating) {
        RatingAverage rta = musicPoint.save(rating);
        return new ResponseEntity<RatingAverage>(rta, HttpStatus.CREATED);
    }
}
