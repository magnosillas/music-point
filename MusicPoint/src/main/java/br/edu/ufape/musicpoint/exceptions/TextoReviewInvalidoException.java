package br.edu.ufape.musicpoint.exceptions;

import br.edu.ufape.musicpoint.basica.Review;

public class TextoReviewInvalidoException extends Exception {
    private final Review review;

    public TextoReviewInvalidoException(Review review) {
        super("Numero de caracteres excedido.");
        this.review = review;
    }

    public Review getReview() {
        return review;
    }
}
