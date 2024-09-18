package com.example.recordshopapp.model;

import com.google.gson.annotations.SerializedName;

public class Album {

    @SerializedName("id")
    private Long id;

    @SerializedName("title")
    private String title;

    @SerializedName("artist")
    private String artist;

    @SerializedName("genre")
    private String genre;

    @SerializedName("releaseYear")
    private int releaseYear;

    @SerializedName("price")
    private double price;

    public Album(){}

    public Album(Long id, String title, String artist, String genre, int releaseYear, double price) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "Album{" +
                "id=" + id +
                ", title=" + title + '\'' +
                ", artist=" + artist + '\'' +
                ", genre=" + genre + '\'' +
                ", releaseYear=" + releaseYear + '\'' +
                ", price=" + price + '\'' +
                '}';

    }

}
