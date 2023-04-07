package br.edu.ufape.musicpoint.repositorio;

import br.edu.ufape.musicpoint.basica.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryReview extends JpaRepository<Review, Long > {
}
