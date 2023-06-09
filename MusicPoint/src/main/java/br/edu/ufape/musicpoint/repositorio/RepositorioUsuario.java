package br.edu.ufape.musicpoint.repositorio;

import br.edu.ufape.musicpoint.basica.Usuario;
import jakarta.validation.constraints.Min;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long > {

    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> findByEmail(String email);

}
