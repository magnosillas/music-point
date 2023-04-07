package br.edu.ufape.musicpoint.basica;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    private String username;
    private String email;
    private String password;
    private String photoURL;
    private String biography;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<User> seguindo;
    @ManyToMany
    private List<User> seguidores;

    public User() {
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

    public List<User> getSeguindo() {
        if (seguindo == null)
            seguindo = new ArrayList<User>();
        return seguindo;
    }

    public void setSeguindo(List<User> seguindo) {
        this.seguindo = seguindo;
    }

    public List<User> getSeguidores() {
        if (seguidores == null)
            seguidores = new ArrayList<User>();
        return seguidores;
    }

    public void setSeguidores(List<User> seguidores) {
        this.seguidores = seguidores;
    }
}
