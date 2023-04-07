package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basica.PostReview;
import br.edu.ufape.musicpoint.fachada.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/postreview")
public class PostReviewController {
    @Autowired
    private MusicPoint musicPoint;

    @PostMapping("cadastrarPostReview")
    public PostReview createPostReview(@RequestBody PostReview postReview){ return musicPoint.save(postReview); }
}
