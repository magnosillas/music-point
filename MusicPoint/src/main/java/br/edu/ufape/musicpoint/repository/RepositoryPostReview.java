package br.edu.ufape.musicpoint.repository;

import br.edu.ufape.musicpoint.basic.PostReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPostReview extends JpaRepository<PostReview, Long> {
}
