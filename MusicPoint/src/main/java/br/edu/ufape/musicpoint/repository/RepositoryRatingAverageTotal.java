package br.edu.ufape.musicpoint.repository;

import br.edu.ufape.musicpoint.basic.RatingAverageTotal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryRatingAverageTotal extends JpaRepository<RatingAverageTotal, Long > {
}
