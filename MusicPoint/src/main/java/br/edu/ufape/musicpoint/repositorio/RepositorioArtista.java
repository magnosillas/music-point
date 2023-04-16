package br.edu.ufape.musicpoint.repositorio;

import br.edu.ufape.musicpoint.basica.Album;
import br.edu.ufape.musicpoint.basica.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioArtista extends JpaRepository<Artista,Long> {
    public List<Artista> findByNomeIgnoreCase(String nome);
}
