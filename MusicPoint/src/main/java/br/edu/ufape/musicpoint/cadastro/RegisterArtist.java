package br.edu.ufape.musicpoint.cadastro;


import br.edu.ufape.musicpoint.basica.Artist;
import br.edu.ufape.musicpoint.repositorio.RepositoryArtist;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegisterArtist {

    @Autowired
    private RepositoryArtist repositoryArtist;

    public Artist cadastrarArtista(Artist artist){
        return repositoryArtist.save(artist);
    }
}
