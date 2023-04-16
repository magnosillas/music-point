package br.edu.ufape.musicpoint.basica;

import jakarta.persistence.Entity;

@Entity
public class Artista extends Conteudo {
    private String nome;
    private String photoURL;

    public Artista() {
    }

    public Artista(String name, String photoURL) {
        this.nome = name;
        this.photoURL = photoURL;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }


}
