package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Usuario;
import br.edu.ufape.musicpoint.repositorio.RepositorioUsuario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CadastroUsuario {
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public Usuario cadastrarUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    public Usuario procurarIdUsuario(long id) {
        return repositorioUsuario.findById(id).orElse(null);
    }

    public Usuario adicionarContaUsuario(Long usuarioID, Long seguirUsuarioID) {
        Usuario usuario = this.procurarIdUsuario(usuarioID);
        Usuario seguirUsuario = this.procurarIdUsuario(seguirUsuarioID);
        List<Usuario> seguindo = usuario.getSeguindo();
        seguindo.add(seguirUsuario);
        return usuario;
    }


    public Usuario atualizarContaUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }


    public void deletarUsuario(Usuario usuario) {
        repositorioUsuario.delete(usuario);
    }
}
