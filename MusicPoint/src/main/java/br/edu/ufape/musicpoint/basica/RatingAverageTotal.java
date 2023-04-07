package br.edu.ufape.musicpoint.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RatingAverageTotal {
    private String generalGrade;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public RatingAverageTotal() {
    }

    public String getGeneralGrade() {
        return generalGrade;
    }

    public void setGeneralGrade(String generalGrade) {
        this.generalGrade = generalGrade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
