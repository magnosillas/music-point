package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Musica;
import br.edu.ufape.musicpoint.repositorio.RepositorioMusica;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CadastroMusica {
    @Autowired
    private RepositorioMusica repositorioMusica;

    public Musica cadastrarMusica(Musica musica) {
        return repositorioMusica.save(musica);
    }
}
