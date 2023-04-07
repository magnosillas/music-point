package br.edu.ufape.musicpoint.controller;

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
@RequestMapping("musicpoint/api/")
public class UserController {
    @Autowired
    private MusicPoint musicPoint;
    @Autowired
    private CadastroUsuario cadastroUsuario;

    //@PostMapping(value = "/seguir")
    //public ResponseEntity<String> seguirConta(@RequestBody User user, @PathVariable long UserId) {

    //}




    @PostMapping(value = "{usuarioId}/{usuarioDestinoID}")
    public ResponseEntity<User> adicionarContaCliente(@PathVariable long usuarioId, @PathVariable long usuarioDestinoID) {
        try {
            return ResponseEntity.ok(cadastroUsuario.adicionarContaUsuario(usuarioId,usuarioDestinoID));
        } catch(Exception ex) {
            return new ResponseEntity<User> (HttpStatus.BAD_REQUEST);
        }
    }

}
