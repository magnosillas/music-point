package br.edu.ufape.musicpoint.repositorio;

import br.edu.ufape.musicpoint.basica.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryReview extends JpaRepository<Review, Long > {
}