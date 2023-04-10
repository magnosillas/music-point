package br.edu.ufape.musicpoint.exceptions;

import br.edu.ufape.musicpoint.basica.Review;

public class MaxCaracteresReviewExcedidoException extends Exception {
    private final Review review;

    public MaxCaracteresReviewExcedidoException(Review review) {
        this.review = review;
    }

    public Review getReview() {
        return review;
    }
}
