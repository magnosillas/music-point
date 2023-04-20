package br.edu.ufape.musicpoint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.musicpoint.repositorio.RepositorioReview;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufape.musicpoint.basica.Artista;
import br.edu.ufape.musicpoint.basica.Conteudo;
import br.edu.ufape.musicpoint.basica.Musica;
import br.edu.ufape.musicpoint.basica.Review;
import br.edu.ufape.musicpoint.basica.Usuario;
import br.edu.ufape.musicpoint.cadastro.CadastroReview;
import br.edu.ufape.musicpoint.exceptions.MaxCaracteresReviewExcedidoException;
import br.edu.ufape.musicpoint.exceptions.NomeReviewInvalidoException;
import br.edu.ufape.musicpoint.exceptions.ReviewNaoEncontradoException;
import br.edu.ufape.musicpoint.exceptions.TextoReviewInvalidoException;

@SpringBootTest
@Transactional
public class CadastroReviewTest {

    private CadastroReview cadastroReview;

    //simula comportamento do banco de dados
    @Autowired
    @Mock
    private RepositorioReview repositorioReview;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cadastroReview = new CadastroReview();
        cadastroReview.setRepositorioReview(repositorioReview);
    }

    @Test
    void testCadastrarReviewExcedeCaracteres() {
        Review review = new Review();
        review.setId(3L);
        review.setTitulo("Review 3");

        Exception exception = assertThrows(TextoReviewInvalidoException.class, () -> {
            cadastroReview.cadastrar(review);
        });

        assertEquals("Numero de caracteres excedido.", exception.getMessage());
    }

    @Test
    void testCadastrarReviewSemTitulo() {
        Review review = new Review();
        review.setId(2L);
        review.setTexto("Texto do review 2");

        Exception exception = assertThrows(NomeReviewInvalidoException.class, () -> {
            cadastroReview.cadastrar(review);
        });

        assertEquals("O campo título não pode estar vazio", exception.getMessage());
    }


}