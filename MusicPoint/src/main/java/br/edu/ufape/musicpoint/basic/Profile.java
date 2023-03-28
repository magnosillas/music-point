package br.edu.ufape.musicpoint.basic;

public class Profile {
    private char genre;
    private String biography;

    public Profile() {
    }

    public Profile(char genre, String biography) {
        this.genre = genre;
        this.biography = biography;
    }

    public boolean updateProfile(){
        return true;
    }

    public boolean follow(){
        return true;
    }


    public char getGenre() {
        return genre;
    }

    public void setGenre(char genre) {
        this.genre = genre;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
