package br.edu.ufape.musicpoint.exceptions;

import br.edu.ufape.musicpoint.basica.Review;
import org.hibernate.ObjectNotFoundException;

public class ReviewNaoEncontradoException extends Exception {
    private Review review;

//    public ReviewNaoEncontradoException(Review review) {
//        //this("Post");
//        this.review = review;
//    }

    public Review getReview() {
        return review;
    }
}
