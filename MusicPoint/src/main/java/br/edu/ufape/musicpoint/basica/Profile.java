package br.edu.ufape.musicpoint.basica;

public class Profile {
    private char genre;
    private Photo photo;
    private String biography;

    public Profile() {
    }

    public Profile(char genre, Photo photo, String biography) {
        this.genre = genre;
        this.photo = photo;
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

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
