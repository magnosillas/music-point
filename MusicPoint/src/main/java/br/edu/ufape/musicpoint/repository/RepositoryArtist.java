package br.edu.ufape.musicpoint.repository;

import br.edu.ufape.musicpoint.basic.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryArtist extends JpaRepository<Artist,Long> {
}