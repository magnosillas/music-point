package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.PostReview;
import br.edu.ufape.musicpoint.repositorio.RepositoryPostReview;
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
