package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Review;
import br.edu.ufape.musicpoint.basica.Usuario;

import java.util.List;

public interface InterfaceReview {

    List<Review> buscarPorAutor(Usuario usuario);
    List<Review> followingPosts(List<Usuario> seguindo);

    Review cadastrar(Review object);
    Review atualizar(Review object);
    void deletar(Review object);
    Review buscarPorId(Long id);

}
