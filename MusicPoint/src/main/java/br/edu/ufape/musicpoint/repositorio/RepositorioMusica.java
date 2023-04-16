package br.edu.ufape.musicpoint.repositorio;

import br.edu.ufape.musicpoint.basica.Artista;
import br.edu.ufape.musicpoint.basica.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioMusica extends JpaRepository<Musica, Long > {
}
