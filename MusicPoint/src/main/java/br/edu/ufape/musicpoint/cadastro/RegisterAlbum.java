package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Album;
import br.edu.ufape.musicpoint.repositorio.RepositorioAlbum;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RegisterAlbum {
    @Autowired
    private RepositorioAlbum repositoryAlbum;

    public Album save(Album album){
        return repositoryAlbum.save(album);
    }

    public List<Album> findByArtist(String artist){
         return repositoryAlbum.findByArtist(artist);
    }



}
