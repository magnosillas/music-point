package br.edu.ufape.musicpoint.exceptions;

import br.edu.ufape.musicpoint.basica.Album;
import br.edu.ufape.musicpoint.basica.Artista;
import br.edu.ufape.musicpoint.basica.Usuario;
import org.hibernate.ObjectNotFoundException;


public class ArtistaNaoEncontradoException extends ObjetoNaoEncontradoException {
    private Artista artista;

    public ArtistaNaoEncontradoException() {
        super("Album");
    }

    public ArtistaNaoEncontradoException(Artista artista) {
        this();
        this.artista = artista;
    }

    public Artista getArtista() {
        return artista;
    }
}

