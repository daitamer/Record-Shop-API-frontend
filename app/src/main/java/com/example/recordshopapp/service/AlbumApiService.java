package com.example.recordshopapp.service;

import com.example.recordshopapp.model.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AlbumApiService {
    @GET("albums")
    Call<List<Album>> getAllAlbums();

    @POST("albums")
    Call<Album> addAlbum(@Body Album album);
}
