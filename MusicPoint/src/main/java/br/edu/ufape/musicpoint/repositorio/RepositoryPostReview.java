package br.edu.ufape.musicpoint.repositorio;

import br.edu.ufape.musicpoint.basica.PostReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPostReview extends JpaRepository<PostReview, Long> {
}
