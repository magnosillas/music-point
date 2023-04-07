package br.edu.ufape.musicpoint.repositorio;

import br.edu.ufape.musicpoint.basica.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioAlbum extends JpaRepository<Album, Long > {

    public List<Album> findByArtist(String artist);

}
