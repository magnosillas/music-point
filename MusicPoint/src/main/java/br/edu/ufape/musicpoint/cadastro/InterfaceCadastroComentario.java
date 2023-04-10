package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Comentario;
import br.edu.ufape.musicpoint.basica.Postagem;
import br.edu.ufape.musicpoint.basica.Usuario;

import java.util.List;

public interface InterfaceCadastroComentario {


    List<Comentario> buscarPelaPostagem( Postagem post);

    List<Comentario> buscarPeloAutor(Usuario autor);

    Comentario cadastrar(Comentario object);
    void deletar(Comentario object);

    Comentario buscarPeloId(Long id);

}
