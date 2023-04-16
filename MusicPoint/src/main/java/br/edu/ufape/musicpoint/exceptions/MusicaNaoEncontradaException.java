package br.edu.ufape.musicpoint.exceptions;

import br.edu.ufape.musicpoint.basica.Album;
import br.edu.ufape.musicpoint.basica.Musica;
import br.edu.ufape.musicpoint.basica.Usuario;
import org.hibernate.ObjectNotFoundException;


public class MusicaNaoEncontradaException extends ObjetoNaoEncontradoException {
    private Musica musica;

    public MusicaNaoEncontradaException() {
        super("Musica");
    }

    public MusicaNaoEncontradaException(Musica musica) {
        this();
        this.musica = musica;
    }

    public Musica getMusica() {
        return musica;
    }
}
