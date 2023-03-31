package br.edu.ufape.musicpoint.register;

import br.edu.ufape.musicpoint.basic.PostReview;
import br.edu.ufape.musicpoint.repository.RepositoryPostReview;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegisterPostReview {
    @Autowired
    private RepositoryPostReview repositoryPostReview;

    public PostReview save(PostReview postReview) {
        return repositoryPostReview.save(postReview);
    }
}
