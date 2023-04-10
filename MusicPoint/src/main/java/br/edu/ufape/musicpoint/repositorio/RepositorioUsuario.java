package br.edu.ufape.musicpoint.repositorio;

import br.edu.ufape.musicpoint.basica.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long > {



}
