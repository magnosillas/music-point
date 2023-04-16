package br.edu.ufape.musicpoint.exceptions;

import br.edu.ufape.musicpoint.basica.Album;
import br.edu.ufape.musicpoint.basica.Usuario;
import org.hibernate.ObjectNotFoundException;


public class AlbumNaoEncontradoException extends ObjetoNaoEncontradoException {
    private Album album;

    public AlbumNaoEncontradoException() {
        super("Album");
    }

    public AlbumNaoEncontradoException(Album album) {
        this();
        this.album = album;
    }

    public Album getAlbum() {
        return album;
    }
}
