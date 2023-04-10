package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basica.Usuario;
import br.edu.ufape.musicpoint.cadastro.CadastroUsuario;
import br.edu.ufape.musicpoint.fachada.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/v1")
public class UsuarioController {
    @Autowired
    private MusicPoint musicPoint;
    @Autowired
    private CadastroUsuario cadastroUsuario;


    @PostMapping("/usuario")
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario){
        Usuario us = musicPoint.save(usuario);
        return new ResponseEntity<Usuario>(us, HttpStatus.CREATED) ;
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> findByIdUser(@PathVariable long id){
        if (musicPoint.procurarUserId(id) != null) {
            return new ResponseEntity<Usuario>(musicPoint.procurarUserId(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
    }



    @PostMapping(value = "usuario/{usuarioId}/{usuarioDestinoID}")
    public ResponseEntity<Usuario> seguirUsuario(@PathVariable long usuarioId, @PathVariable long usuarioDestinoID) {
        try {
            return ResponseEntity.ok(cadastroUsuario.seguirUsuario(usuarioId,usuarioDestinoID));
        } catch(Exception ex) {
            return new ResponseEntity<Usuario> (HttpStatus.BAD_REQUEST);
        }
    }

}
