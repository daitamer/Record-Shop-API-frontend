package com.example.recordshopapp;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.recordshopapp.model.Album;
import com.example.recordshopapp.service.AlbumApiService;
import com.example.recordshopapp.service.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        AlbumApiService service = RetrofitInstance.getRetrofitInstance().create(AlbumApiService.class);
        Call<List<Album>> call = service.getAllAlbums();

        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                if (response.isSuccessful()) {
                    List<Album> albums = response.body();

                    Log.d("MainActivity", "Albums fetched successfully: " + albums);
                } else {
                    Toast.makeText(MainActivity.this, "Failed to fetch albums", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Log.e("MainActivity", "Error fetching albums: " + t.getMessage());
                Toast.makeText(MainActivity.this, "Error fetching albums", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}