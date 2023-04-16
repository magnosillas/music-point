package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Album;
import br.edu.ufape.musicpoint.basica.Artista;
import br.edu.ufape.musicpoint.exceptions.AlbumNaoEncontradoException;
import br.edu.ufape.musicpoint.repositorio.RepositorioAlbum;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CadastroAlbum {
    @Autowired
    private RepositorioAlbum repositoryAlbum;

    public Album cadastrarAlbum(Album album){
        return repositoryAlbum.save(album);
    }

    public List<Album> buscarTodos(){
        return repositoryAlbum.findAll();
    }

    public List<Album> buscarPorArtista(Artista artista)        throws AlbumNaoEncontradoException
    {
        Optional<List<Album>> album = Optional.ofNullable(repositoryAlbum.findByArtista(artista));
        if(album.isEmpty())
            throw new AlbumNaoEncontradoException();
        return album.get();
    }

    public List<Album> buscarPorNome(String nome)        throws AlbumNaoEncontradoException
    {
        Optional<List<Album>> album = Optional.ofNullable(repositoryAlbum.findByNome(nome));
        if(album.isEmpty())
            throw new AlbumNaoEncontradoException();
        return album.get();
    }

    public Album procurarAlbumId(long id)        throws AlbumNaoEncontradoException
    {
        Optional<Album> album = repositoryAlbum.findById(id);
        if(album.isEmpty())
            throw new AlbumNaoEncontradoException();
        return album.get();
    }


}
