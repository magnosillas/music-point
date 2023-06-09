package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Review;
import br.edu.ufape.musicpoint.basica.Usuario;
import br.edu.ufape.musicpoint.exceptions.MaxCaracteresReviewExcedidoException;
import br.edu.ufape.musicpoint.exceptions.NomeReviewInvalidoException;
import br.edu.ufape.musicpoint.exceptions.ReviewNaoEncontradoException;
import br.edu.ufape.musicpoint.exceptions.TextoReviewInvalidoException;

import java.util.List;

public interface InterfaceReview {

    List<Review> buscarPorAutor(Usuario usuario);
    List<Review> followingPosts(List<Usuario> seguindo);

    Review cadastrar(Review object) throws NomeReviewInvalidoException, TextoReviewInvalidoException, MaxCaracteresReviewExcedidoException;
    Review atualizar(Review object) throws TextoReviewInvalidoException, MaxCaracteresReviewExcedidoException, NomeReviewInvalidoException, ReviewNaoEncontradoException;
    void deletar(Review object) throws ReviewNaoEncontradoException;
    Review buscarPorId(Long id) throws ReviewNaoEncontradoException;

}
