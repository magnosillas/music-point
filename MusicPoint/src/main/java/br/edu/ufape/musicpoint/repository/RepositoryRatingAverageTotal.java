package br.edu.ufape.musicpoint.repository;

import br.edu.ufape.musicpoint.basic.RatingAverageTotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRatingAverageTotal extends JpaRepository<RatingAverageTotal, Long > {
}
