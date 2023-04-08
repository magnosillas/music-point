package br.edu.ufape.musicpoint.repositorio;

import br.edu.ufape.musicpoint.basica.RatingAverage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRatingAverage extends JpaRepository<RatingAverage, Long > {
}
