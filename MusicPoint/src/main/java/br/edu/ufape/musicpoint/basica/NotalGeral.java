package br.edu.ufape.musicpoint.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NotalGeral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double nota;

    public NotalGeral() {
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double generalGrade) {
        this.nota = generalGrade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
