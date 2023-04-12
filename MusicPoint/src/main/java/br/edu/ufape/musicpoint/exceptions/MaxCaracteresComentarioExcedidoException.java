package br.edu.ufape.musicpoint.exceptions;

import br.edu.ufape.musicpoint.basica.Comentario;

public class MaxCaracteresComentarioExcedidoException extends Exception {
    private final Comentario comentario;

    public MaxCaracteresComentarioExcedidoException(Comentario comentario) {
        super("O texto da postagem não pode ser maior que 700 caracteres");
        this.comentario = comentario;
    }
    public Comentario getComment() {
        return comentario;
    }


}