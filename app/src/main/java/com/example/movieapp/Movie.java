package com.example.movieapp;

import java.io.Serializable;

public class Movie implements Serializable {
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

    public int getYear() {
        return year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return type;
    }

    public String getPosterUrl() {
        return posterUrl;
    }
}
