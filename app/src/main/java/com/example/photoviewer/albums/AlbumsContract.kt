package com.example.photoviewer.albums

import com.example.photoviewer.BaseContact
import com.example.photoviewer.data.Album

interface AlbumsContract {
    interface View : BaseContact {
        fun showAlbums(albums: List<Album>?)

        fun setPresenter(presenter: AlbumsContract.Presenter)

    }

    interface Presenter : BaseContact {
        fun loadAlbums(albums: List<Album>?)

        fun getAlbums()

    }

}