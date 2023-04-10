package br.edu.ufape.musicpoint.exceptions;

import br.edu.ufape.musicpoint.basica.Usuario;

public class UsernameInvalidoException extends Exception{

    private final Usuario usuario;

    public UsernameInvalidoException(Usuario usuario){
        super("O nome do username não pode ser nulo, vazio ou conter espaços e/ou caracteres especiais");
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
