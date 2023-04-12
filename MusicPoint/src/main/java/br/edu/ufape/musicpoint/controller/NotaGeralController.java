package br.edu.ufape.musicpoint.controller;

import br.edu.ufape.musicpoint.basica.NotalGeral;
import br.edu.ufape.musicpoint.fachada.MusicPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musicpoint/api/v1/nota")
public class NotaGeralController {
    @Autowired
    private MusicPoint musicPoint;

    @PostMapping
    public ResponseEntity<NotalGeral> criarNotaGeral(@RequestBody NotalGeral rating) {
        NotalGeral rta = musicPoint.save(rating);
        return new ResponseEntity<NotalGeral>(rta, HttpStatus.CREATED);
    }
}
