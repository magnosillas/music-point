package br.edu.ufape.musicpoint.basica;

import jakarta.persistence.*;
import org.apache.catalina.User;

@Entity
public class Review extends Postagem{

    private String titulo;
    @ManyToOne
    private Album album;

    private int nota;

    public Review() {
        super();
    }

    public  Review(Usuario autor, String texto, String titulo, Album album, int nota){
        super(autor,texto);
        this.album = album;

        this.nota = nota;
        this.titulo=titulo;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


}
