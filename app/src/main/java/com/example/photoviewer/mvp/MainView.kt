package com.example.photoviewer.mvp

import android.support.v7.widget.RecyclerView
import com.example.photoviewer.api.Album
import com.example.photoviewer.api.Photo

interface MainView {
    val albumsRecyclerView: RecyclerView

    fun showAlbums(albums: List<Album>)

    fun showPhotos(photos: List<Photo>)

    fun setAlbumIdForPhotos(albumId: Int)

    fun showApiError(resId: String?)
}
