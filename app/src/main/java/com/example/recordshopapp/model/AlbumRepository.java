package com.example.recordshopapp.model;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.example.recordshopapp.service.AlbumApiService;
import com.example.recordshopapp.service.RetrofitInstance;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {

    private final MutableLiveData<List<Album>> mutableLiveData;
    private final AlbumApiService albumApiService;

    public AlbumRepository(Application application) {
        mutableLiveData = new MutableLiveData<>();
        albumApiService = RetrofitInstance.getRetrofitInstance().create(AlbumApiService.class);
        fetchAlbums();
    }

    public MutableLiveData<List<Album>> getMutableLiveData() {
        return mutableLiveData;
    }

    private void fetchAlbums() {
        Call<List<Album>> call = albumApiService.getAllAlbums();
        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Album> albums = response.body();
                    mutableLiveData.setValue(albums);
                } else {
                    mutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                mutableLiveData.setValue(null);
            }
        });
    }
}
