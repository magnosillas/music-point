package br.edu.ufape.musicpoint.exceptions;
import br.edu.ufape.musicpoint.basica.Review;

public class ReviewNaoEncontradoException extends ObjetoNaoEncotradoException {
    private Review review;

    public ReviewNaoEncontradoException() {
        super("nomeClasse");
    }

    public ReviewNaoEncontradoException(Review review) {
        this();
        this.review = review;
    }

    public Review getReview() {
        return review;
    }
}
