package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Comentario;
import br.edu.ufape.musicpoint.basica.Postagem;
import br.edu.ufape.musicpoint.basica.Usuario;
import br.edu.ufape.musicpoint.exceptions.ComentarioInvalidoException;
import br.edu.ufape.musicpoint.exceptions.ComentarioNaoEncontradoException;
import br.edu.ufape.musicpoint.exceptions.MaxCaracteresComentarioExcedidoException;

import java.util.List;

public interface InterfaceCadastroComentario {
    List<Comentario> buscarPelaPostagem(Postagem post);

    List<Comentario> buscarPeloAutor(Usuario autor);

    Comentario cadastrar(Comentario object) throws ComentarioInvalidoException, MaxCaracteresComentarioExcedidoException;
    void deletar(Comentario object) throws ComentarioNaoEncontradoException;

    Comentario buscarPeloId(Long id) throws ComentarioNaoEncontradoException;

}
