package br.edu.ufape.musicpoint.repository;

import br.edu.ufape.musicpoint.basic.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryReview extends JpaRepository<Review, Long > {
}
