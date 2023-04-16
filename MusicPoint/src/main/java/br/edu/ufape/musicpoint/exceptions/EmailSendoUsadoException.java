package br.edu.ufape.musicpoint.exceptions;

import br.edu.ufape.musicpoint.basica.Usuario;

import java.util.Optional;

public class EmailSendoUsadoException extends Exception {
    private final Usuario usuarioSalvoEmail;
    private final Usuario usuario;

    public EmailSendoUsadoException(Usuario usuarioSalvoEmail, Usuario usuario) {
        super("Este email está sendo usado por outro usuário");
        this.usuarioSalvoEmail = usuarioSalvoEmail;
        this.usuario = usuario;
    }

    public Usuario getUsuarioSalvoEmail() {
        return usuarioSalvoEmail;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
