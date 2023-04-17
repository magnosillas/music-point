package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Artista;
import br.edu.ufape.musicpoint.exceptions.ArtistaNaoEncontradoException;

import java.util.List;

public interface InterfaceCadastroArtista {

    public Artista cadastrarArtista(Artista artista);

    public List<Artista> buscarTodos() throws ArtistaNaoEncontradoException;
    public Artista buscarPorId(long id) throws ArtistaNaoEncontradoException;
    public Artista buscarPorNome(String nome)        throws ArtistaNaoEncontradoException;


}
