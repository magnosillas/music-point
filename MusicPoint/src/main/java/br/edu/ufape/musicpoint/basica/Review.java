package br.edu.ufape.musicpoint.basica;

import jakarta.persistence.*;
import org.apache.catalina.User;

@Entity
public class Review extends Postagem{

    private String titulo;
    @ManyToOne
    private Conteudo conteudo;
    private String conteudoTipo;
    private int nota;

    public Review() {
        super();
    }

    public  Review(Usuario autor, String texto, String titulo, Conteudo conteudo, int nota){
        super(autor,texto);
        this.conteudo = conteudo;
        if(conteudo instanceof Album){
            this.conteudoTipo = "Álbum";
        } else if (conteudo instanceof Musica) {
            this.conteudoTipo = "Musica";
        } else{
            this.conteudoTipo = "Artista";
        }
        this.nota = nota;
        this.titulo=titulo;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getConteudoTipo() {
        return conteudoTipo;
    }

    public void setConteudoTipo(String conteudoTipo) {
        this.conteudoTipo = conteudoTipo;
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
