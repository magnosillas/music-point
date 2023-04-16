package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basica.Usuario;
import br.edu.ufape.musicpoint.exceptions.UsernameExistenteException;
import br.edu.ufape.musicpoint.exceptions.UsernameInvalidoException;
import br.edu.ufape.musicpoint.exceptions.UsuarioNaoEncontradoException;
import br.edu.ufape.musicpoint.fachada.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/v1/usuario")
public class UsuarioController {
    @Autowired
    private MusicPoint musicPoint;



    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario){
        try {
            return new ResponseEntity<Usuario>(musicPoint.save(usuario), HttpStatus.CREATED);
        } catch (UsernameExistenteException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (UsernameInvalidoException e) {
            return ResponseEntity.unprocessableEntity().build();
        }

    }
    @PatchMapping
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario) {
        try {
            return ResponseEntity.ok(musicPoint.atualizar(usuario));
        } catch (UsuarioNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        } catch (UsernameExistenteException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (UsernameInvalidoException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @GetMapping("lista")
    public ResponseEntity<List<Usuario>> buscarTodos(){
        return new ResponseEntity<List<Usuario>>(musicPoint.buscarTodosUsuarios(), HttpStatus.OK);
    }

    @DeleteMapping("username/{username}")
    public ResponseEntity<Void> deletarUsername(@PathVariable String username) {
        try {
            musicPoint.deletar(username);
            return ResponseEntity.noContent().build();
        } catch (UsuarioNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("id/{usuarioid}")
    public ResponseEntity<Void> deletarUsername(@PathVariable Long usuarioid) {
        try {
            musicPoint.deletar(usuarioid);
            return ResponseEntity.noContent().build();
        } catch (UsuarioNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable long id){
        try {
            if (musicPoint.buscarUsuario(id) != null) {
                return new ResponseEntity<Usuario>(musicPoint.buscarUsuario(id), HttpStatus.OK);
            } else {
                return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
            }
        } catch (UsuarioNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("username/{username}")
    public ResponseEntity<Usuario> buscarPorUsername(@PathVariable String username){
        try {
            if (musicPoint.buscarUsuario(username) != null) {
                return new ResponseEntity<Usuario>(musicPoint.buscarUsuario(username), HttpStatus.OK);
            } else {
                return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
            }
        } catch (UsuarioNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }



    @PatchMapping(value = "seguir/id/{usuarioId}/{usuarioDestinoID}")
    public ResponseEntity<Usuario> seguirUsuarioId(@PathVariable long usuarioId, @PathVariable long usuarioDestinoID) {
        try {
            return ResponseEntity.ok(musicPoint.seguirUsuario(usuarioId,usuarioDestinoID));
        } catch(Exception ex) {
            return new ResponseEntity<Usuario> (HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping(value = "seguir/username/{usuarioUsername}/{usuarioDestinoUsername}")
    public ResponseEntity<Usuario> seguirUsuarioUsername(@PathVariable String usuarioUsername, @PathVariable String usuarioDestinoUsername) {
        try {
            return ResponseEntity.ok(musicPoint.seguirUsuario(usuarioUsername,usuarioDestinoUsername));
        } catch(Exception ex) {
            return new ResponseEntity<Usuario> (HttpStatus.BAD_REQUEST);
        }
    }

}
