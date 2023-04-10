package br.edu.ufape.musicpoint.exceptions;

import br.edu.ufape.musicpoint.basica.Review;

public class NomeReviewInvalidoException extends Exception {
    private final Review review;

    public NomeReviewInvalidoException(Review review) {
        super("O campo título não pode estar vazio");
        this.review = review;
    }

    public Review getReview() {
        return review;
    }
}
