package br.edu.ufape.musicpoint.basica;

import jakarta.persistence.ManyToOne;

public class Comentario extends Postagem{
    @ManyToOne
    private Postagem post;

    public Comentario() {
        super();
    }

    public Comentario(Usuario autor, String texto, Postagem postagem) {
        super(autor, texto);
        this.post = postagem;
    }

    public Postagem getPost() {
        return post;
    }

    public void setPost(Postagem post) {
        this.post = post;
    }
}
