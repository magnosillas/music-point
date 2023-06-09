package br.edu.ufape.musicpoint.basica;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Album extends Conteudo {
    private String nome;
    private String foto;
    private int rank;
    @OneToMany
    private List<Musica> musicas;
    @ManyToOne
    private Artista artista;

    public Album() {
    }

    public Album(String nome, String photoAlbumURL, int rank) {
        this.nome = nome;
        this.foto = photoAlbumURL;
        this.rank = rank;
    }

    public Album(String nome, String foto, int rank, List<Musica> musicas, Artista artista) {
        this.nome = nome;
        this.foto = foto;
        this.rank = rank;
        this.musicas = musicas;
        this.artista = artista;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String photoAlbumURL) {
        this.foto = photoAlbumURL;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
}
