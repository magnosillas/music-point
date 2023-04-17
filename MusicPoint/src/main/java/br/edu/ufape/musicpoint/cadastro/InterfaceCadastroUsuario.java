package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Usuario;
import br.edu.ufape.musicpoint.exceptions.*;

import java.util.List;

public interface InterfaceCadastroUsuario {
    public Usuario cadastrar(Usuario usuario) throws UsernameInvalidoException, UsernameExistenteException, EmailSendoUsadoException;
    public Usuario buscarPorId(long id) throws UsuarioNaoEncontradoException;
    public Usuario buscarPorUsername(String username) throws UsuarioNaoEncontradoException;

    public List<Usuario> buscarTodos() throws UsuarioNaoEncontradoException;

    public Usuario atualizar(Usuario usuario) throws UsernameInvalidoException, UsernameExistenteException,
            UsuarioNaoEncontradoException, EmailSendoUsadoException;

    public void deletar(Usuario usuario) throws UsuarioNaoEncontradoException;

    public Usuario buscarPorEmail(String email) throws UsuarioNaoEncontradoException;

    public Usuario login(String email, String password) throws UsuarioNaoEncontradoException, SenhaIncorretaException;

}
