package br.edu.ufape.musicpoint.exceptions;


import br.edu.ufape.musicpoint.basica.Usuario;

public class UsuarioJaSeguidoException extends Exception {
    private Usuario seguindo;
    private Usuario seguidores;

    public UsuarioJaSeguidoException(Usuario seguindo, Usuario seguidores) {
        super("Você já segue este usuário");
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
