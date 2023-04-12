package br.edu.ufape.musicpoint.exceptions;

import br.edu.ufape.musicpoint.basica.Comentario;

public class ComentarioNaoEncontradoException extends ObjetoNaoEncontradoException {
    private Comentario comentario;

    public ComentarioNaoEncontradoException() {
        super("Comentario");
    }

    public ComentarioNaoEncontradoException(Comentario comentario) {
        this();
        this.comentario = comentario;
    }
    public Comentario getComment() {
        return comentario;
    }

}

