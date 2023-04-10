package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Usuario;

public interface InterfaceCadastroUsuario {
    Usuario procurarIdUsuario(long id);

    Usuario seguirUsuario(Long usuarioID, Long seguirUsuarioID);

    Usuario atualizar(Usuario usuario);

    void deletarUsuario(Usuario usuario);
}
