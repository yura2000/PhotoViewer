package com.example.photoviewer.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.photoviewer.api.Album
import com.example.photoviewer.mvp.MainPresenter


class AlbumRecyclerAdapter(private val values: List<Album>, private val presenter: MainPresenter?) : RecyclerView.Adapter<AlbumViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AlbumViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(com.example.photoviewer.R.layout.item_title, p0, false)
        return AlbumViewHolder(itemView, presenter)
    }

    override fun getItemCount() = values.size

    override fun onBindViewHolder(holderAlbum: AlbumViewHolder, pos: Int) {
        val album: Album = values[pos]
        holderAlbum.bind(album)
    }
}
