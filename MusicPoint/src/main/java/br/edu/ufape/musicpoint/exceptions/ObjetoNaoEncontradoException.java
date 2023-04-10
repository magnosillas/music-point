package br.edu.ufape.musicpoint.exceptions;

public abstract class ObjetoNaoEncontradoException extends Exception {

    public ObjetoNaoEncontradoException(String nomeClasse) {

        super(String.format("%s nao encontrado", nomeClasse));
    }

}
