package br.edu.ufape.musicpoint.exceptions;

import br.edu.ufape.musicpoint.basica.Usuario;

public class UsuarioNaoSeguidoException extends Exception {
    private final Usuario seguindo;
    private final Usuario seguidores;

    public UsuarioNaoSeguidoException(Usuario seguindo, Usuario seguidores) {
        super("Você não segue este usuário");
        this.seguindo = seguindo;
        this.seguidores = seguidores;
    }

    public Usuario getSeguindo() {
        return seguindo;
    }

    public Usuario getSeguidores() {
        return seguidores;
    }
}
