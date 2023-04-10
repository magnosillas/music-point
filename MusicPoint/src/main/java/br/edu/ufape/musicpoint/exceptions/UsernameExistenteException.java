package br.edu.ufape.musicpoint.exceptions;

import br.edu.ufape.musicpoint.basica.Usuario;

public class UsernameExistenteException extends Exception {
    private final Usuario novoUsuario;
    private final Usuario usuarioExistente;

    public UsernameExistenteException(Usuario novoUsuario, Usuario usuarioExistente) {
        super("Two users cannot have the same username");
        this.novoUsuario = novoUsuario;
        this.usuarioExistente = usuarioExistente;
    }

    public Usuario getNovoUsuario() {
        return novoUsuario;
    }

    public Usuario getUsuarioExistente() {
        return usuarioExistente;
    }
}
