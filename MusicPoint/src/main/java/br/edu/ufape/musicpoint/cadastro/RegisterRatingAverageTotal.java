package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.RatingAverageTotal;
import br.edu.ufape.musicpoint.repositorio.RepositoryRatingAverageTotal;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegisterRatingAverageTotal {
    @Autowired
    private RepositoryRatingAverageTotal repositoryRatingAverageTotal;

    public RatingAverageTotal save(RatingAverageTotal ratingAverageTotal) {
        return repositoryRatingAverageTotal.save(ratingAverageTotal);
    }
}
