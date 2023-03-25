package br.edu.ufape.musicpoint.basica;

import jakarta.persistence.*;


@Entity
public class PostReview {
    private Review review;
    private int likes;
    private int unlikes;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public PostReview() {
    }

    public boolean like(){

        return false;
    }

    public boolean unlike(){

        return false;
    }


    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
