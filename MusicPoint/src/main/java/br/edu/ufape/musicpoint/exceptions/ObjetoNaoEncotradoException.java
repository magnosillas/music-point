package br.edu.ufape.musicpoint.exceptions;

public abstract class ObjetoNaoEncotradoException extends Exception {
    public ObjetoNaoEncotradoException(String nomeClasse) {
        super(String.format("%s não encontrado", nomeClasse));
    }
}
