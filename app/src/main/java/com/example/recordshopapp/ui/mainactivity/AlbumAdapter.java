package com.example.recordshopapp.ui.mainactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recordshopapp.R;
import com.example.recordshopapp.model.Album;
import com.example.recordshopapp.databinding.AlbumItemsBinding;

import java.util.ArrayList;
import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>{

    private ArrayList<Album> albumList;
    private Context context;

    public AlbumAdapter(ArrayList<Album> albumList, Context context) {
        this.albumList = albumList;
        this.context = context;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AlbumItemsBinding albumItemsBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.album_items,
                parent,
                false);
        return new AlbumViewHolder(albumItemsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {

        Album album = albumList.get(position);
        holder.albumItemBinding.setAlbum(album);
//        holder.albumItemBinding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {

        private AlbumItemsBinding albumItemBinding;

        public AlbumViewHolder(AlbumItemsBinding albumItemBinding) {
            super(albumItemBinding.getRoot());
            this.albumItemBinding = albumItemBinding;
        }
    }

}
