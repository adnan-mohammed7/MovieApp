package com.example.movieapp;

public class Movie {
    String title;
    int year;
    String imdbID;
    String type;
    String posterUrl;

    public Movie(String title, int year, String id, String type, String url){
        this.title = title;
        this.year = year;
        this.imdbID = id;
        this.type = type;
        this.posterUrl = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
}
