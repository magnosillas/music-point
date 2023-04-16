package br.edu.ufape.musicpoint.exceptions;

public class SenhaIncorretaException extends Exception {
    private final String senhaUsuario;
    private final String senhaLogin;



    public SenhaIncorretaException(String senhaUsuario, String senhaLogin){
        super("Senha não corresponde");
        this.senhaLogin = senhaLogin;
        this.senhaUsuario = senhaUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public String getSenhaLogin() {
        return senhaLogin;
    }
}
