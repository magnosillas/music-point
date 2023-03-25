package br.edu.ufape.musicpoint.basica;

import jakarta.persistence.ManyToOne;

import java.util.List;

public class Timeline {
    private long id;

    @ManyToOne
    private List<PostReview> postReviews;

    public Timeline() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<PostReview> getPostReviews() {
        return postReviews;
    }

    public void setPostReviews(List<PostReview> postReviews) {
        this.postReviews = postReviews;
    }

    public void updateTimeline() {
    }
}
