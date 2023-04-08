package br.edu.ufape.musicpoint.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Review {
    @Id
    private long id;
    private String text;
    private String albumPhoto;
    private int likes;


    public void setId(long id) {
        this.id = id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
