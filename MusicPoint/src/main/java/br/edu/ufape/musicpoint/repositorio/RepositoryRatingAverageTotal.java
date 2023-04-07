package br.edu.ufape.musicpoint.repositorio;

import br.edu.ufape.musicpoint.basica.RatingAverageTotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRatingAverageTotal extends JpaRepository<RatingAverageTotal, Long > {
}
