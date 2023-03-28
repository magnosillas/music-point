package br.edu.ufape.musicpoint.register;

import br.edu.ufape.musicpoint.basic.Album;
import br.edu.ufape.musicpoint.repository.RepositoryAlbum;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RegisterAlbum {
    @Autowired
    private RepositoryAlbum repositoryAlbum;

    public Album save(Album album){
        return repositoryAlbum.save(album);
    }

    public List<Album> findByArtist(String artist){
         return repositoryAlbum.findByArtist(artist);
    }



}
