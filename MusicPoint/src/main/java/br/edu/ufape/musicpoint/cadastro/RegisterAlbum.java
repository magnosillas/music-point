package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Album;
import br.edu.ufape.musicpoint.repositorio.RepositorioAlbum;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegisterAlbum {
    @Autowired
    private RepositorioAlbum repositoryAlbum;

    public Album cadastrarAlbum(Album album){
        return repositoryAlbum.save(album);
    }

    public Album procurarAlbumId(long id){
        return repositoryAlbum.findById(id).orElse(null);
    };


}
