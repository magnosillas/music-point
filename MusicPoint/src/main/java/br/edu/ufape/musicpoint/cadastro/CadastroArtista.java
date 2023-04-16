package br.edu.ufape.musicpoint.cadastro;


import br.edu.ufape.musicpoint.basica.Album;
import br.edu.ufape.musicpoint.basica.Artista;
import br.edu.ufape.musicpoint.basica.Musica;
import br.edu.ufape.musicpoint.basica.Usuario;
import br.edu.ufape.musicpoint.exceptions.AlbumNaoEncontradoException;
import br.edu.ufape.musicpoint.exceptions.ArtistaNaoEncontradoException;
import br.edu.ufape.musicpoint.exceptions.UsuarioNaoEncontradoException;
import br.edu.ufape.musicpoint.repositorio.RepositorioArtista;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CadastroArtista {

    @Autowired
    private RepositorioArtista repositorioArtista;

    public Artista cadastrarArtista(Artista artista){
        return repositorioArtista.save(artista);
    }


    public Artista buscarPorId(long id)
            throws ArtistaNaoEncontradoException
    {
        Optional<Artista> artista = repositorioArtista.findById(id);
        if(artista.isEmpty())
            throw new ArtistaNaoEncontradoException();
        return artista.get();
    }

    public List<Artista> buscarPorNome(String nome)        throws ArtistaNaoEncontradoException
    {
        Optional<List<Artista>> artista = Optional.ofNullable(repositorioArtista.findByNomeIgnoreCase(nome));
        if(artista.isEmpty())
            throw new ArtistaNaoEncontradoException();
        return artista.get();
    }

    public List<Artista> buscarTodos(){
        return repositorioArtista.findAll();
    }
}
