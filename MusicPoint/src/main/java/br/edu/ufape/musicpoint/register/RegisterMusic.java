package br.edu.ufape.musicpoint.register;

import br.edu.ufape.musicpoint.basic.Music;
import br.edu.ufape.musicpoint.repository.RepositoryMusic;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegisterMusic {
    @Autowired
    private RepositoryMusic repositoryMusic;

    public Music save(Music music) {
        return repositoryMusic.save(music);
    }
}
