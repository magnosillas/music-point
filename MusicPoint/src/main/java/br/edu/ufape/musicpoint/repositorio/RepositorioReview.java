package br.edu.ufape.musicpoint.repositorio;

import br.edu.ufape.musicpoint.basica.Review;
import br.edu.ufape.musicpoint.basica.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioReview extends JpaRepository<Review, Long > {

    List<Review> findByAutorOrderByDataCriacaoDesc(Usuario author);
    List<Review> findByAutorInOrderByDataCriacaoDesc(List<Usuario> authors);

}
