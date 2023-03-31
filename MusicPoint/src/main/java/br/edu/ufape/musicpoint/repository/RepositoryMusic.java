package br.edu.ufape.musicpoint.repository;

import br.edu.ufape.musicpoint.basic.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMusic extends JpaRepository<Music, Long > {
}
