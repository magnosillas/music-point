package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.User;
import br.edu.ufape.musicpoint.repositorio.RepositoryUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CadastroUsuario {
    @Autowired
    private RepositoryUser repositoryUser;

    public User cadastrarUsuario(User user) {
        return repositoryUser.save(user);
    }


    public User procurarIdUsuario(long id) {
        return repositoryUser.findById(id).orElse(null);
    }


    public User adicionarContaUsuario(Long usuarioID, Long seguirUsuarioID) {

        User usuario = this.procurarIdUsuario(usuarioID);
        User seguirUsuario = this.procurarIdUsuario(seguirUsuarioID);
        List<User> seguindo = usuario.getSeguindo();
        seguindo.add(seguirUsuario);

        return usuario;
    }


    public User atualizarContaUsuario(User user) {
        return repositoryUser.save(user);
    }


    public void deletarUsuario(User user) {
        repositoryUser.delete(user);
    }
}
