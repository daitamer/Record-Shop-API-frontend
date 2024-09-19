package com.example.recordshopapp.ui.mainactivity;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recordshopapp.R;
import com.example.recordshopapp.model.Album;
import com.example.recordshopapp.service.AlbumApiService;
import com.example.recordshopapp.service.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Album> albumList;
//    private AlbumAdapter albumAdapter;
//    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        AlbumApiService service = RetrofitInstance.getRetrofitInstance().create(AlbumApiService.class);
//        Call<List<Album>> call = service.getAllAlbums();
//
//        call.enqueue(new Callback<List<Album>>() {
//            @Override
//            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    List<Album> albums = response.body();
//
//                    Log.d("MainActivity", "Albums fetched successfully: " + albums);
//                } else {
//                    Log.d("MainActivity", "Failed to fetch albums");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Album>> call, Throwable t) {
//                Log.e("MainActivity", "Error fetching albums: " + t.getMessage());
//            }
//        });
//
//
    }
}