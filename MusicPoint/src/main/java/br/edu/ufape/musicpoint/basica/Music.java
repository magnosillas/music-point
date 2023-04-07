package br.edu.ufape.musicpoint.basica;

import jakarta.persistence.Entity;

@Entity
public class Music extends Content{

    private String name;


    public Music() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
