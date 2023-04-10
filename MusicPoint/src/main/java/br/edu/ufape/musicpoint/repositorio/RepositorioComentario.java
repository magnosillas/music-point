package br.edu.ufape.musicpoint.repositorio;

import br.edu.ufape.musicpoint.basica.Comentario;
import br.edu.ufape.musicpoint.basica.Postagem;
import br.edu.ufape.musicpoint.basica.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RepositorioComentario extends JpaRepository<Comentario, Long> {
        List<Comentario> findByPost(Postagem post);
        List<Comentario> findByAutor(Usuario autor);
}
