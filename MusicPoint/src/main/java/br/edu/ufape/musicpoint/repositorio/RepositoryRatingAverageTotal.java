package br.edu.ufape.musicpoint.repositorio;

import br.edu.ufape.musicpoint.basica.RatingAverageTotal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryRatingAverageTotal extends JpaRepository<RatingAverageTotal, Long > {
}
