package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basica.User;
import br.edu.ufape.musicpoint.fachada.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/usuario")
public class UserController {
    @Autowired
    private MusicPoint musicPoint;

    //@PostMapping(value = "/seguir")
    //public ResponseEntity<String> seguirConta(@RequestBody User user, @PathVariable long UserId) {

    //}
}
