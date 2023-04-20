package br.edu.ufape.musicpoint;

import br.edu.ufape.musicpoint.basica.Usuario;
import br.edu.ufape.musicpoint.cadastro.CadastroUsuario;
import br.edu.ufape.musicpoint.exceptions.UsernameInvalidoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CadastroUsuarioTest {
    @Autowired
    private CadastroUsuario cadastroUsuario;

    private Usuario usuario;

    // criando objeto pra teste
    @BeforeEach
    public void beforeEach() {
        usuario = new Usuario("isamin", "isamin@example.com", "senha123");
    }

    @Test
    public void testCadastrarUsuario() {
        try {
            Usuario usuarioCadastrado = cadastroUsuario.cadastrar(usuario);
            assertNotNull(usuarioCadastrado.getId());
            assertEquals(usuario.getUsername(), usuarioCadastrado.getUsername());
            assertEquals(usuario.getEmail(), usuarioCadastrado.getEmail());
            assertEquals(usuario.getPassword(), usuarioCadastrado.getPassword());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testCadastrarUsuarioComUsernameInvalido() {
        usuario.setUsername("john@doe");
        assertThrows(UsernameInvalidoException.class, () -> cadastroUsuario.cadastrar(usuario));
    }

    @Test
    public void testBuscarPorId() {
        try {
            Usuario usuarioCadastrado = cadastroUsuario.cadastrar(usuario);
            Usuario usuarioEncontrado = cadastroUsuario.buscarPorId(usuarioCadastrado.getId());
            assertNotNull(usuarioEncontrado);
            assertEquals(usuarioCadastrado, usuarioEncontrado);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}