package br.edu.ufape.musicpoint.basica;

import br.edu.ufape.musicpoint.exceptions.UsuarioJaSeguidoException;
import br.edu.ufape.musicpoint.exceptions.UsuarioNaoSeguidoException;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String photoURL;
    private String biography;

    @ManyToMany
    private List<Usuario> seguindo;

    private int seguidores;

    public Usuario() {

    }

    public Usuario(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public boolean seguir(Usuario usuario) throws UsuarioJaSeguidoException {
        if (seguindo.contains(usuario))
            throw new UsuarioJaSeguidoException(this, usuario);
        return seguindo.add(usuario);
    }

    public boolean pararSeguir(Usuario usuario) throws UsuarioNaoSeguidoException
    {
        if (!seguindo.contains(usuario))
             throw new UsuarioNaoSeguidoException(this, usuario);

        return seguindo.remove(usuario);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario outro = (Usuario) obj;
        return seguidores == outro.seguidores && Objects.equals(seguindo, outro.seguindo)
                && Objects.equals(id, outro.id) && username.equals(outro.username)
                && email.equals(outro.email);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Usuario> getSeguindo() {
        if (seguindo == null)
            seguindo = new ArrayList<Usuario>();
        return seguindo;
    }

    public void setSeguindo(List<Usuario> seguindo) {
        this.seguindo = seguindo;
    }

    public int getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(int seguidores) {
        this.seguidores = seguidores;
    }
}
