package br.edu.ufape.musicpoint.basica;

import jakarta.persistence.Entity;

@Entity
public class Musica extends Conteudo {
    private String name;
    public Musica() {
    }

    public Musica(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
