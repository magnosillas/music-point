package br.edu.ufape.musicpoint.basica;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Album extends Conteudo {
    private String name;
    private String releaseDate;
    private String genre;
    private String photoAlbumURL;
    @OneToMany
    private List<Musica> musicas;
    @OneToOne
    private Artista artista;


    public Album() {
    }




    public String getPhotoAlbumURL() {
        return photoAlbumURL;
    }

    public void setPhotoAlbumURL(String photoAlbumURL) {
        this.photoAlbumURL = photoAlbumURL;
    }

    public List<Musica> getMusics() {
        return musicas;
    }

    public void setMusics(List<Musica> musicas) {
        this.musicas = musicas;
    }

    public Artista getArtist() {
        return artista;
    }

    public void setArtist(Artista artista) {
        this.artista = artista;
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
