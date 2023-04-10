package br.edu.ufape.musicpoint.basica;

import jakarta.persistence.*;
import org.apache.catalina.User;

@Entity
public class Review extends Postagem{

    private String titulo;
    @ManyToOne
    private Conteudo conteudo;

    public Review() {
        super();
    }

    public  Review(Usuario autor, String texto, String titulo, Conteudo conteudo){
        super(autor,texto);
        this.conteudo = conteudo;
        this.titulo=titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Conteudo getConteudo() {
        return conteudo;
    }

    public void setConteudo(Conteudo conteudo) {
        this.conteudo = conteudo;
    }
}
