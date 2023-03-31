package br.edu.ufape.musicpoint.register;

import br.edu.ufape.musicpoint.basic.Review;
import br.edu.ufape.musicpoint.repository.RepositoryReview;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegisterReview {
    @Autowired
    private RepositoryReview repositoryReview;

    public Review save(Review review) {
        return repositoryReview.save(review);
    }
}
