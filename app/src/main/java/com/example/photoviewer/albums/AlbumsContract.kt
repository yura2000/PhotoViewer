package com.example.photoviewer.albums

import android.view.View
import com.example.photoviewer.BaseContact
import com.example.photoviewer.data.Album

interface AlbumsContract {
    interface View : BaseContact {
        fun showAlbums(albums: List<Album>?)

        fun setPresenter(presenter: AlbumsContract.Presenter)

        fun showConcreteAlbumActivity(pos: Int?)
    }

    interface Presenter : BaseContact {
        fun loadAlbums(albums: List<Album>?)

        fun getAlbums()

        fun onAlbumSelected(album: Album?)
    }

}