package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Review;
import br.edu.ufape.musicpoint.repositorio.RepositoryReview;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegisterReview {
    @Autowired
    private RepositoryReview repositoryReview;

    public Review cadastrarReview(Review review) {
        return repositoryReview.save(review);
    }
}
