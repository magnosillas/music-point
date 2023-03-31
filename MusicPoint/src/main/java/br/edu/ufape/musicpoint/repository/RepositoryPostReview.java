package br.edu.ufape.musicpoint.repository;

import br.edu.ufape.musicpoint.basic.PostReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPostReview extends JpaRepository<PostReview, Long> {
}
