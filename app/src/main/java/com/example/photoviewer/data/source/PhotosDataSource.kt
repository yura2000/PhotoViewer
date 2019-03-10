package com.example.photoviewer.data.source

import com.example.photoviewer.albums.AlbumsContract
import com.example.photoviewer.concrete_album.ConcreteAlbumContract
import com.example.photoviewer.data.Photo

interface PhotosDataSource {

    fun getPhotos(albumId: Int)

    fun setPresenter(presenter: ConcreteAlbumContract.Presenter)

}