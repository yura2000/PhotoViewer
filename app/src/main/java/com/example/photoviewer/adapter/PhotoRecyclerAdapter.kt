package com.example.photoviewer.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.photoviewer.api.Album
import com.example.photoviewer.api.Photo
import com.example.photoviewer.mvp.MainPresenter

class PhotoRecyclerAdapter(private val values: List<Photo>, private val presenter: MainPresenter?) : RecyclerView.Adapter<PhotoViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PhotoViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(com.example.photoviewer.R.layout.item_title, p0, false)
        return PhotoViewHolder(itemView, presenter)
    }

    override fun getItemCount() = values.size

    override fun onBindViewHolder(holder: PhotoViewHolder, pos: Int) {
        val photo: Photo = values[pos]
        holder.bind(photo)
    }
}
