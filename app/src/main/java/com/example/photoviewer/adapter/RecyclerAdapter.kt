package com.example.photoviewer.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.photoviewer.R
import com.example.photoviewer.api.Album

class RecyclerAdapter(private val values: List<Album>): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.item_title, p0, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = values.size

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        val album: Album = values[pos]
        holder.bind(album)
    }
}
