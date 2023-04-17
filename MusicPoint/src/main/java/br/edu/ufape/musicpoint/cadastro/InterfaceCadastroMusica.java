package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Musica;
import br.edu.ufape.musicpoint.exceptions.MusicaNaoEncontradaException;

import java.util.List;

public interface InterfaceCadastroMusica {

    public Musica cadastrarMusica(Musica musica);

    public List<Musica> buscarTodos() throws MusicaNaoEncontradaException;
    public Musica buscarPorId(long id) throws MusicaNaoEncontradaException;
    public Musica buscarPorNome(String nome) throws MusicaNaoEncontradaException;

}
