package br.edu.ufape.musicpoint.exceptions;

import br.edu.ufape.musicpoint.basica.Usuario;
import org.hibernate.ObjectNotFoundException;


public class UsuarioNaoEncontradoException extends ObjetoNaoEncontradoException {
    private Usuario usuario;

    public UsuarioNaoEncontradoException() {
        super("Usuario");
    }

    public UsuarioNaoEncontradoException(Usuario usuario) {
        this();
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
