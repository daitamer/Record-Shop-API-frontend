package com.example.recordshopapp.model;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import com.example.recordshopapp.service.AlbumApiService;
import com.example.recordshopapp.service.RetrofitInstance;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {

    private MutableLiveData<List<Album>> mutableLiveData;
    private Application application;

    public AlbumRepository(Application application) {
        this.application = application;
        this.mutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<Album>> getAllAlbums() {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<List<Album>> call = albumApiService.getAllAlbums();
        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {

                    List<Album> albums = response.body();
                mutableLiveData.setValue(albums);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Log.e("GET request", t.getMessage());
            }
        });
        return mutableLiveData;
    }
}
