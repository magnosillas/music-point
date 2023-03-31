package br.edu.ufape.musicpoint.repository;

import br.edu.ufape.musicpoint.basic.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryReview extends JpaRepository<Review, Long > {
}
