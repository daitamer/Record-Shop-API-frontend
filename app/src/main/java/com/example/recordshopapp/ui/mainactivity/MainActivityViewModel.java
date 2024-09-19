package com.example.recordshopapp.ui.mainactivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.recordshopapp.model.Album;
import com.example.recordshopapp.model.AlbumRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    AlbumRepository albumRepository;

    public MainActivityViewModel(@NonNull Application application, AlbumRepository albumRepository) {
        super(application);
        this.albumRepository = new AlbumRepository(application);
    }

    public LiveData<List<Album>> getAlbums(){
        return albumRepository.getAllAlbums();
    }


}
