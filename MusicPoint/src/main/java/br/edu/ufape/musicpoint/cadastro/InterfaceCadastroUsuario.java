package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.User;

import java.util.List;

public interface InterfaceCadastroUsuario {
    User procurarIdUsuario(long id);

    User adicionarContaUsuario(User user, User novoUsuario);

    User atualizarContaUsuario(User user);

    void deletarUsuario(User user);
}
