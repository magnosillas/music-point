package br.edu.ufape.musicpoint.repository;

import br.edu.ufape.musicpoint.basic.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryAlbum extends JpaRepository<Album, Long > {

    public List<Album> findByArtist(String artist);

}
