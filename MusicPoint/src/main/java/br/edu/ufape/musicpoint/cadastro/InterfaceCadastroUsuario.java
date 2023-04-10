package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Usuario;

public interface InterfaceCadastroUsuario {
    Usuario procurarIdUsuario(long id);

    Usuario adicionarContaUsuario(Long usuarioID, Long seguirUsuarioID);

    Usuario atualizarContaUsuario(Usuario usuario);

    void deletarUsuario(Usuario usuario);
}
