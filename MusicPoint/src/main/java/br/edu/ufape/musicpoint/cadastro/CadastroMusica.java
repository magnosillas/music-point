package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Artista;
import br.edu.ufape.musicpoint.basica.Musica;
import br.edu.ufape.musicpoint.exceptions.ArtistaNaoEncontradoException;
import br.edu.ufape.musicpoint.exceptions.MusicaNaoEncontradaException;
import br.edu.ufape.musicpoint.repositorio.RepositorioMusica;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CadastroMusica {
    @Autowired
    private RepositorioMusica repositorioMusica;

    public Musica cadastrarMusica(Musica musica) {
        return repositorioMusica.save(musica);
    }

    public List<Musica> buscarTodos() throws MusicaNaoEncontradaException {
        List<Musica> musicas = repositorioMusica.findAll();
        if(musicas.size() == 0 ){
            throw new MusicaNaoEncontradaException();
        }else{
            return musicas;
        }


    }

    public Musica buscarPorId(long id) throws MusicaNaoEncontradaException {
        Optional<Musica> musica = repositorioMusica.findById(id);
        if(musica.isEmpty())
            throw new MusicaNaoEncontradaException();
        return musica.get();
    }

    public Musica buscarPorNome(String nome) throws MusicaNaoEncontradaException {
        Optional<Musica> musica = Optional.ofNullable(repositorioMusica.findByNomeIgnoreCase(nome));
        if(musica.isEmpty())
            throw new MusicaNaoEncontradaException();
        return musica.get();
    }
}
