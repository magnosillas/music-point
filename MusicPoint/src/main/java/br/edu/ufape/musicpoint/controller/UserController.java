package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basica.Album;
import br.edu.ufape.musicpoint.basica.Music;
import br.edu.ufape.musicpoint.basica.User;
import br.edu.ufape.musicpoint.cadastro.CadastroUsuario;
import br.edu.ufape.musicpoint.fachada.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/v1")
public class UserController {
    @Autowired
    private MusicPoint musicPoint;
    @Autowired
    private CadastroUsuario cadastroUsuario;

    //@PostMapping(value = "/seguir")
    //public ResponseEntity<String> seguirConta(@RequestBody User user, @PathVariable long UserId) {

    //}
    @PostMapping("usuario")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User us = musicPoint.save(user);
        return new ResponseEntity<User>(us, HttpStatus.CREATED) ;
    }

    @GetMapping("usuario/{id}")
    public ResponseEntity<User> findByIdUser(@PathVariable long id){
        if (musicPoint.procurarUserId(id) != null) {
            return new ResponseEntity<User>(musicPoint.procurarUserId(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }



    @PostMapping(value = "{usuarioId}/{usuarioDestinoID}")
    public ResponseEntity<User> adicionarContaCliente(@PathVariable long usuarioId, @PathVariable long usuarioDestinoID) {
        try {
            return ResponseEntity.ok(cadastroUsuario.adicionarContaUsuario(usuarioId,usuarioDestinoID));
        } catch(Exception ex) {
            return new ResponseEntity<User> (HttpStatus.BAD_REQUEST);
        }
    }

}
