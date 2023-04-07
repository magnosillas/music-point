package br.edu.ufape.musicpoint.repositorio;

import br.edu.ufape.musicpoint.basica.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryMusic extends JpaRepository<Music, Long > {
}
