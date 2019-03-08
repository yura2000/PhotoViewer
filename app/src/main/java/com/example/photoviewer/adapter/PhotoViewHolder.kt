package com.example.photoviewer.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.photoviewer.api.Photo
import com.example.photoviewer.mvp.MainPresenter

class PhotoViewHolder(itemView: View, presenter: MainPresenter?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    var photoTitle: TextView? = null
    var photoId: TextView? = null
    private var presenter: MainPresenter? = null

    init {
        photoTitle = itemView.findViewById(com.example.photoviewer.R.id.itemTitle_tv)
        photoId = itemView.findViewById(com.example.photoviewer.R.id.itemId_tv)
        this.presenter = presenter
    }

    override fun onClick(v: View?) {
        presenter?.setPhotosIdForPhoto(adapterPosition)
    }

    fun bind(photo: Photo) {
        photoTitle?.text = photo.title
        photoId?.text = photo.id.toString()
        itemView.setOnClickListener(this)
    }
}