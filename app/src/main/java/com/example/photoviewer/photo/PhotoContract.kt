package com.example.photoviewer.photo

import com.example.photoviewer.BaseContact
import com.example.photoviewer.concrete_album.ConcreteAlbumContract
import com.example.photoviewer.data.Photo

interface PhotoContract {
    interface View : BaseContact {
        fun showPhoto(photoUrl: String?)

        fun setPresenter(presenter: PhotoContract.Presenter)

    }

    interface Presenter : BaseContact {
        fun loadPhoto(photoUrl: String?)

        fun getPhotos(photoId: Int?)

    }

}