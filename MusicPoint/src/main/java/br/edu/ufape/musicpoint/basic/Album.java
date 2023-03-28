package br.edu.ufape.musicpoint.basic;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Album extends Content{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String releaseDate;
    private String genre;
    private String photoAlbumURL;
    @OneToMany
    private List<Music> musics;
    @OneToOne
    private Artist artist;


    public Album() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
