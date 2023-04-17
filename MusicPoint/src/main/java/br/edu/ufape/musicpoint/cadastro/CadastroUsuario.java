package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.Usuario;
import br.edu.ufape.musicpoint.exceptions.*;
import br.edu.ufape.musicpoint.repositorio.RepositorioUsuario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CadastroUsuario {
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public Usuario cadastrar(Usuario usuario) throws UsernameInvalidoException, UsernameExistenteException, EmailSendoUsadoException {
        if(usuario.getUsername() == null ||
            usuario.getUsername().isBlank() ||
            !usuario.getUsername().matches("[a-zA-Z0-9_.-]+"))
            throw new UsernameInvalidoException(usuario);
        Optional<Usuario> usuarioSalvoEmail = repositorioUsuario.findByEmail(usuario.getEmail());
        if(usuarioSalvoEmail.isPresent() && !usuarioSalvoEmail.get().getId().equals(usuario.getId()))
            throw new EmailSendoUsadoException(usuarioSalvoEmail.get(), usuario);
        Optional<Usuario> usuarioSalvo = repositorioUsuario.findByUsername(usuario.getUsername());
        if (usuarioSalvo.isPresent() && !usuarioSalvo.get().getId().equals(usuario.getId()))
            throw new UsernameExistenteException(usuario, usuarioSalvo.get());
        return repositorioUsuario.save(usuario);
    }

    public Usuario buscarPorId(long id)
    throws UsuarioNaoEncontradoException
    {
        Optional<Usuario> usuario = repositorioUsuario.findById(id);
        if(usuario.isEmpty())
            throw new UsuarioNaoEncontradoException();
        return usuario.get();
    }

    public Usuario buscarPorUsername(String username)
    throws UsuarioNaoEncontradoException
    {
        Optional<Usuario> usuario = repositorioUsuario.findByUsername(username);
        if(usuario.isEmpty())
            throw new UsuarioNaoEncontradoException();
        return usuario.get();
    }

    public List<Usuario> buscarTodos(){
        return repositorioUsuario.findAll();
    }



    public Usuario atualizar(Usuario usuario) throws UsernameInvalidoException, UsernameExistenteException, UsuarioNaoEncontradoException, EmailSendoUsadoException {
        Usuario usuarioSalvo = buscarPorId(usuario.getId());
        usuario.setPassword(usuarioSalvo.getPassword());
        return cadastrar(usuario);
    }


    public void deletar(Usuario usuario) throws UsuarioNaoEncontradoException
    {
        buscarPorId(usuario.getId());
        repositorioUsuario.delete(usuario);
    }

    public Usuario buscarPorEmail(String email)
            throws UsuarioNaoEncontradoException
    {
        Optional<Usuario> usuario = repositorioUsuario.findByEmail(email);
        if(usuario.isEmpty())
            throw new UsuarioNaoEncontradoException();
        return usuario.get();
    }

    public Usuario login(String email, String password) throws UsuarioNaoEncontradoException, SenhaIncorretaException {
        Usuario usuario = buscarPorEmail(email);
        String senha = usuario.getPassword();
        if(!password.equals(senha)){
            throw new SenhaIncorretaException(senha,password);
        }
        return usuario;

    }
}
