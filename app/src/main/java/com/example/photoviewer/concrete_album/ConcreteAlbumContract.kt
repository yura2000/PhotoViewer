package com.example.photoviewer.concrete_album

import com.example.photoviewer.BaseContact
import com.example.photoviewer.data.Photo

interface ConcreteAlbumContract {
    interface View : BaseContact {
        fun showPhotos(photos: List<Photo>?)

        fun setPresenter(presenter: ConcreteAlbumContract.Presenter)

        fun showPhotoActivity(photoId: Int?)

    }

    interface Presenter : BaseContact {
        fun loadPhotos(photos: List<Photo>?)

        fun getPhotos()

        fun onConcreteAlbumSelected(photo: Photo?)
    }

}