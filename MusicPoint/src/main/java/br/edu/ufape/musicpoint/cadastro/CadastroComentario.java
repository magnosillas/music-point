package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Comentario;
import br.edu.ufape.musicpoint.basica.Postagem;
import br.edu.ufape.musicpoint.basica.Usuario;
import br.edu.ufape.musicpoint.exceptions.ComentarioInvalidoException;
import br.edu.ufape.musicpoint.exceptions.ComentarioNaoEncontradoException;
import br.edu.ufape.musicpoint.exceptions.MaxCaracteresComentarioExcedidoException;
import br.edu.ufape.musicpoint.repositorio.RepositorioComentario;
import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroComentario implements InterfaceCadastroComentario {

    @Autowired
    private RepositorioComentario repositorioComentario;

    public List<Comentario> buscarPelaPostagem(Postagem post) {
        return null;
    }


    public List<Comentario> buscarPeloAutor(Usuario autor) {
        return null;
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


    public void deletar(Comentario comentario)
    throws ComentarioNaoEncontradoException
    {
        buscarPeloId(comentario.getId());
        repositorioComentario.delete(comentario);
    }


    public Comentario buscarPeloId(Long id)
    throws ComentarioNaoEncontradoException
    {
        Optional<Comentario> comentario = repositorioComentario.findById(id);
        if (comentario.isEmpty())
            throw new ComentarioNaoEncontradoException();

        return comentario.get();
    }
}
