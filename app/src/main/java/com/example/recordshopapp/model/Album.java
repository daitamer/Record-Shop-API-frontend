package com.example.recordshopapp.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.recordshopapp.BR;

import com.google.gson.annotations.SerializedName;

public class Album extends BaseObservable {

    @SerializedName(value = "id")
    private Long id;

    @SerializedName(value="title")
    private String title;

    @SerializedName(value="artist")
    private String artist;

    @SerializedName(value="genre")
    private String genre;

    @SerializedName(value="releaseYear")
    private int releaseYear;

    @SerializedName(value="price")
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

    @Bindable
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        notifyPropertyChanged(BR.id);

    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);

    }

    @Bindable
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
        notifyPropertyChanged(BR.artist);

    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);

    }

    @Bindable
    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        notifyPropertyChanged(BR.releaseYear);

    }

    @Bindable
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyPropertyChanged(BR.price);
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
