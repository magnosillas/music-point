package br.edu.ufape.musicpoint.basica;


import jakarta.persistence.*;

import java.time.Instant;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Postagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Usuario autor;
    private String texto;
    private Instant dataCriacao;
    private int likes;
    private int unlikes;

    public Postagem() {
        this.dataCriacao = Instant.now();
    }

    public Postagem(Usuario autor, String texto) {
        this();
        this.autor = autor;
        this.texto = texto;
    }


    public void like() {
        likes++;
    }

    public void unlike() {
        unlikes++;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Instant getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Instant dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getUnlikes() {
        return unlikes;
    }

    public void setUnlikes(int unlikes) {
        this.unlikes = unlikes;
    }
}
