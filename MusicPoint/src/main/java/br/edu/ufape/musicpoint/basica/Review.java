package br.edu.ufape.musicpoint.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public class Review {
    private long id;
    private String text;

    private String albumPhoto;

    public Review() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



    public String getAlbumPhoto() {
        return albumPhoto;
    }

    public void setAlbumPhoto(String albumPhoto) {
        this.albumPhoto = albumPhoto;
    }
}
