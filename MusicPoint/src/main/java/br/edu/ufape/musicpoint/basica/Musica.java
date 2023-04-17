package br.edu.ufape.musicpoint.basica;

import jakarta.persistence.Entity;

@Entity
public class Musica extends Conteudo {
    private String nome;
    public Musica() {
    }

    public Musica(String name) {
        this.nome = name;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }


}
