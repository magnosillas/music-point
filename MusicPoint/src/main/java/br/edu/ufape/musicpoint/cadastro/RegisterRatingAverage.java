package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.RatingAverage;
import br.edu.ufape.musicpoint.repositorio.RepositoryRatingAverage;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegisterRatingAverage {
    @Autowired
    private RepositoryRatingAverage repositoryRatingAverageTotal;

    public RatingAverage cadastrarMediaNotas(RatingAverage ratingAverageTotal) {
        return repositoryRatingAverageTotal.save(ratingAverageTotal);
    }
}
