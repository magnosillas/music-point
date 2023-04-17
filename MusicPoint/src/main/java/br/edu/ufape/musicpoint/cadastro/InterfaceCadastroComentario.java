package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Comentario;
import br.edu.ufape.musicpoint.basica.Review;
import br.edu.ufape.musicpoint.basica.Usuario;
import br.edu.ufape.musicpoint.exceptions.ComentarioInvalidoException;
import br.edu.ufape.musicpoint.exceptions.ComentarioNaoEncontradoException;
import br.edu.ufape.musicpoint.exceptions.MaxCaracteresComentarioExcedidoException;

import java.util.List;

public interface InterfaceCadastroComentario {
    List<Comentario> buscarPeloPost(Review post) throws ComentarioNaoEncontradoException;

    List<Comentario> buscarPeloAutor(Usuario autor) throws ComentarioNaoEncontradoException;

    Comentario cadastrar(Comentario object) throws ComentarioInvalidoException, MaxCaracteresComentarioExcedidoException;
    void deletar(Comentario object) throws ComentarioNaoEncontradoException;

    Comentario buscarPorId(Long id) throws ComentarioNaoEncontradoException;

}
