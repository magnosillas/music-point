package br.edu.ufape.musicpoint.register;


import br.edu.ufape.musicpoint.basic.Artist;
import br.edu.ufape.musicpoint.repository.RepositoryArtist;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegisterArtist {

    @Autowired
    private RepositoryArtist repositoryArtist;

    public Artist save(Artist artist){
        return repositoryArtist.save(artist);
    }
}
