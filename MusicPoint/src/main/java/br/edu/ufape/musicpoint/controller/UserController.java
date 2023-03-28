package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basic.Artist;
import br.edu.ufape.musicpoint.basic.User;
import br.edu.ufape.musicpoint.front.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/user")
public class UserController {
    @Autowired
    private MusicPoint musicPoint;

    @PostMapping("cadastrarUsuario")
    public User createUser(@RequestBody User user){
        return musicPoint.save(user);
    }
}
