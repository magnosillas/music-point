package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Review;
import br.edu.ufape.musicpoint.repositorio.RepositorioReview;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CadastroReview {
    @Autowired
    private RepositorioReview repositorioReview;

    public Review cadastrarReview(Review review) {
        return repositorioReview.save(review);
    }
}
