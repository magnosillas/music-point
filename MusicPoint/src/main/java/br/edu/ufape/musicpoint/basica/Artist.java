package br.edu.ufape.musicpoint.basica;

import jakarta.persistence.Entity;

@Entity
public class Artist extends Content{
    private String name;
    private String photoURL;


    public Artist() {
    }

    public Artist(String name, String photoURL) {
        this.name = name;
        this.photoURL = photoURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }


}
