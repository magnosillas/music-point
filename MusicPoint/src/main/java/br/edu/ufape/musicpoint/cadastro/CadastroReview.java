package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Review;
import br.edu.ufape.musicpoint.basica.Usuario;
import br.edu.ufape.musicpoint.exceptions.ReviewNaoEncontradoException;
import br.edu.ufape.musicpoint.repositorio.RepositorioReview;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufape.musicpoint.exceptions.NomeReviewInvalidoException;
import br.edu.ufape.musicpoint.exceptions.TextoReviewInvalidoException;
import br.edu.ufape.musicpoint.exceptions.MaxCaracteresReviewExcedidoException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CadastroReview implements InterfaceReview{
    @Autowired
    private RepositorioReview repositorioReview;

    @Override
    public Review buscarPorId(Long id) throws ReviewNaoEncontradoException {
        Optional<Review> review = repositorioReview.findById(id);
        if (review.isEmpty())
            throw new ReviewNaoEncontradoException();
        return review.get();
    }

    @Override
    public List<Review> buscarPorAutor(Usuario usuario) {
        return repositorioReview.findByAutorOrderByDataCriacaoDesc(usuario);
    }

    @Override
    public List<Review> followingPosts(List<Usuario> seguindo) {
        return repositorioReview.findByAutorInOrderByDataCriacaoDesc(seguindo);
    }

    @Override
    public Review cadastrar(Review review)
            throws NomeReviewInvalidoException, TextoReviewInvalidoException, MaxCaracteresReviewExcedidoException
    {
        if(review.getTitulo() == null || review.getTitulo().isBlank()){
            throw new NomeReviewInvalidoException(review);
        }
        if(review.getTexto() == null || review.getTexto().isBlank()){
            throw new TextoReviewInvalidoException(review);
        }
        if(review.getTexto().length() > 1500){
            throw new MaxCaracteresReviewExcedidoException(review);
        }
        return repositorioReview.save(review);
    }

    public List<Review> buscarTodos(){
        return repositorioReview.findAll();
    }

    @Override
    public Review atualizar(Review review) throws TextoReviewInvalidoException, MaxCaracteresReviewExcedidoException, NomeReviewInvalidoException, ReviewNaoEncontradoException {
        Review reviewVelho = buscarPorId(review.getId());
        review.setDataCriacao(reviewVelho.getDataCriacao());
        return cadastrar(review);
    }

    @Override
    public void deletar(Review review) throws ReviewNaoEncontradoException {
        buscarPorId(review.getId());
        repositorioReview.delete(review);
    }
}
