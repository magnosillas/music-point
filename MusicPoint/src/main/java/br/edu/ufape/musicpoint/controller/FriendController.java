package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basic.Friend;
import br.edu.ufape.musicpoint.front.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/friend")
public class FriendController {
    @Autowired
    private MusicPoint musicPoint;

    @PostMapping("cadastrarFriend")
    public Friend createFriend(@RequestBody Friend friend){ return musicPoint.save(friend); }
}
