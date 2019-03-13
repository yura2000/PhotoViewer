package com.example.photoviewer.concrete_album.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.photoviewer.concrete_album.ConcreteAlbumClickListener
import com.example.photoviewer.data.Photo

class ConcreteAlbumRecyclerAdapter(private val values: List<Photo>) : RecyclerView.Adapter<ConcreteAlbumViewHolder>() {

    var onClickItem: ConcreteAlbumClickListener? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ConcreteAlbumViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(com.example.photoviewer.R.layout.item_title, p0, false)
        return ConcreteAlbumViewHolder(itemView, onClickItem)
    }

    override fun getItemCount() = values.size

    override fun onBindViewHolder(holder: ConcreteAlbumViewHolder, pos: Int) {
        val photo: Photo = values[pos]
        holder.bind(photo)
    }
}
