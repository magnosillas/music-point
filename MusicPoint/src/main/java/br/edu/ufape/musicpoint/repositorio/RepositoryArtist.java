package br.edu.ufape.musicpoint.repositorio;

import br.edu.ufape.musicpoint.basica.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryArtist extends JpaRepository<Artist,Long> {
}
