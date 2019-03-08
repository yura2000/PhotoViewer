package com.example.photoviewer.mvp

import android.support.v7.widget.RecyclerView
import com.example.photoviewer.api.Album
import com.example.photoviewer.api.Photo

interface MainView {
    val albumsRecyclerView: RecyclerView

    fun showAlbums(albums: List<Album>)

    fun showPhotoTitles(photos: List<Photo>)

    fun showPhoto(photoUrl: String?)

    fun setAlbumIdForPhotos(albumId: Int)

    fun setPhotosIdForPhoto(photoId: Int)

    fun showApiError(resId: String?)
}
