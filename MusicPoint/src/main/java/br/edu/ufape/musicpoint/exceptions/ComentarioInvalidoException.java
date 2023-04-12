package br.edu.ufape.musicpoint.exceptions;

import br.edu.ufape.musicpoint.basica.Comentario;

public class ComentarioInvalidoException extends Exception {
    private final Comentario comentario;

    public ComentarioInvalidoException(Comentario comentario) {
        super("O comentário não pode ser inválido ou vazio");
        this.comentario = comentario;
    }
    public Comentario getComment() {
        return comentario;
    }
}

