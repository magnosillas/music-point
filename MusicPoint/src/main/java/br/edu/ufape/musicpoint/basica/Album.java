package br.edu.ufape.musicpoint.basica;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Album extends Content{

    private String name;

    private int rank;
    private String photoAlbumURL;
    @OneToMany
    private List<Music> musics;
    @OneToOne
    private Artist artist;


    public Album() {
    }

    public Album(String name,int rank, String photoAlbumURL) {
        this.name = name;
        this.photoAlbumURL = photoAlbumURL;
        this.rank = rank;
    }

    public String getPhotoAlbumURL() {
        return photoAlbumURL;
    }

    public void setPhotoAlbumURL(String photoAlbumURL) {
        this.photoAlbumURL = photoAlbumURL;
    }

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        this.musics = musics;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
