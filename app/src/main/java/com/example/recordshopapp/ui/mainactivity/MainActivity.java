package com.example.recordshopapp.ui.mainactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recordshopapp.R;
import com.example.recordshopapp.databinding.ActivityMainBindingImpl;
import com.example.recordshopapp.model.Album;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Album> albumList;
    private AlbumAdapter albumAdapter;
    private MainActivityViewModel viewModel;
    private ActivityMainBindingImpl binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        getAllAlbums();

    }

    private void getAllAlbums() {
        viewModel.getAlbums().observe(this, new Observer<List<Album>>() {

            @Override
            public void onChanged(List<Album> albumsFromLiveData) {

                albumList = (ArrayList<Album>) albumsFromLiveData;

                displayInRecyclerView();

            }
        });
    }

    private void displayInRecyclerView() {

        recyclerView = binding.recyclerview;

        albumAdapter = new AlbumAdapter(albumList, this);

        recyclerView.setAdapter(albumAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setHasFixedSize(true);

        albumAdapter.notifyDataSetChanged();

    }

}