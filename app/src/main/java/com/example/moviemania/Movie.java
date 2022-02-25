package com.example.moviemania;

public class Movie {
    private String title;
    private String imageUrl;
    private String description;

    public Movie(String title, String url, String description) {
        this.title = title;
        this.imageUrl = url;
        this.description= description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
