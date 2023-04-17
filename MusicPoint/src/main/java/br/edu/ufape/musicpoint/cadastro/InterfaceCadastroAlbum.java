package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Album;
import br.edu.ufape.musicpoint.basica.Artista;
import br.edu.ufape.musicpoint.exceptions.AlbumNaoEncontradoException;

import java.util.List;

public interface InterfaceCadastroAlbum {

    public Album cadastrarAlbum(Album album);

    public List<Album> buscarTodos() throws AlbumNaoEncontradoException;
    public List<Album> buscarPorArtista(Artista artista)        throws AlbumNaoEncontradoException;
    public List<Album> buscarPorNome(String nome)        throws AlbumNaoEncontradoException;
    public Album procurarAlbumId(long id)        throws AlbumNaoEncontradoException;

}
