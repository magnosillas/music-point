package br.edu.ufape.musicpoint.repositorio;

import br.edu.ufape.musicpoint.basica.PostReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPostReview extends JpaRepository<PostReview, Long> {
}
