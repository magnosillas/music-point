package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Music;
import br.edu.ufape.musicpoint.repositorio.RepositoryMusic;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegisterMusic {
    @Autowired
    private RepositoryMusic repositoryMusic;

    public Music cadastrarMusica(Music music) {
        return repositoryMusic.save(music);
    }
}
