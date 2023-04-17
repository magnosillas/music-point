package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Comentario;
import br.edu.ufape.musicpoint.basica.Review;
import br.edu.ufape.musicpoint.basica.Usuario;
import br.edu.ufape.musicpoint.exceptions.*;
import br.edu.ufape.musicpoint.repositorio.RepositorioComentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroComentario implements InterfaceCadastroComentario {

    @Autowired
    private RepositorioComentario repositorioComentario;

    public List<Comentario> buscarPeloAutor(Usuario autor) throws ComentarioNaoEncontradoException {
        List<Comentario> comentarios = repositorioComentario.findByAutor(autor);
        if (comentarios.size() == 0) {
            throw new ComentarioNaoEncontradoException();
        } else {
            return comentarios;
        }
    }


    public Comentario cadastrar(Comentario comentario)
    throws ComentarioInvalidoException, MaxCaracteresComentarioExcedidoException
    {
        if(comentario.getTexto().isEmpty() || comentario.getTexto().isBlank()) {
            throw new ComentarioInvalidoException(comentario);
        }
        if(comentario.getTexto().length() > 700) {
            throw new MaxCaracteresComentarioExcedidoException(comentario);
        }
        return repositorioComentario.save(comentario);
    }


    public void deletar(Comentario comentario) throws ComentarioNaoEncontradoException
    {
        buscarPorId(comentario.getId());
        repositorioComentario.delete(comentario);
    }


    public Comentario atualizar(Comentario comentario) throws ComentarioNaoEncontradoException, ComentarioInvalidoException, MaxCaracteresComentarioExcedidoException {
        Comentario comentarioAntigo = buscarPorId(comentario.getId());
        comentario.setDataCriacao(comentarioAntigo.getDataCriacao());
        comentario.setAutor(comentarioAntigo.getAutor());
        comentario.setLikes(comentarioAntigo.getLikes());
        comentario.setUnlikes(comentarioAntigo.getUnlikes());
        return cadastrar(comentario);
    }

    public Comentario buscarPorId(Long id)
    throws ComentarioNaoEncontradoException
    {
        Optional<Comentario> comentario = repositorioComentario.findById(id);
        if (comentario.isEmpty())
            throw new ComentarioNaoEncontradoException();

        return comentario.get();
    }

    public List<Comentario> buscarPeloPost(Review review) throws ComentarioNaoEncontradoException {
        List<Comentario> comentarios = repositorioComentario.findByPost(review);
        if (comentarios.size() == 0) {
            throw new ComentarioNaoEncontradoException();
        } else {
            return comentarios;
        }
    }
}
