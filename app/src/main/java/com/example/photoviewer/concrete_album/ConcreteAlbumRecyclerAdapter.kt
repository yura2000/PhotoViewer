package com.example.photoviewer.concrete_album

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.photoviewer.data.Photo
import com.example.photoviewer.main.MainPresenter

class ConcreteAlbumRecyclerAdapter(private val values: List<Photo>) : RecyclerView.Adapter<ConcreteAlbumViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ConcreteAlbumViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(com.example.photoviewer.R.layout.item_title, p0, false)
        return ConcreteAlbumViewHolder(itemView)
    }

    override fun getItemCount() = values.size

    override fun onBindViewHolder(holder: ConcreteAlbumViewHolder, pos: Int) {
        val photo: Photo = values[pos]
        holder.bind(photo)
    }
}
