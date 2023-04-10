package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Review;
import br.edu.ufape.musicpoint.basica.Usuario;
import br.edu.ufape.musicpoint.repositorio.RepositorioReview;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CadastroReview implements InterfaceReview{
    @Autowired
    private RepositorioReview repositorioReview;


    @Override
    public List<Review> buscarPorAutor(Usuario usuario) {
        return repositorioReview.findByAutorOrderByDataCriacaoDesc(usuario);
    }

    @Override
    public List<Review> followingPosts(List<Usuario> seguindo) {
        return repositorioReview.findByAutorInOrderByDataCriacaoDesc(seguindo);
    }

    @Override
    public Review cadastrar(Review review) {
        return repositorioReview.save(review);
    }

    @Override
    public Review atualizar(Review object) {
        return null;
    }

    @Override
    public void deletar(Review object) {

    }

    @Override
    public Review buscarPorId(Long id)
//    throws ReviewNaoEncontradoException
    {
        Optional<Review> review = repositorioReview.findById(id);
        return null;
    }
}
