package com.example.photoviewer.main

interface MainScreenContract {
    interface View {
        fun startAlbumsFragment()
        fun startConcreteAlbumFragment()
        fun startPhotoFragment()
    }
    interface Presenter {

    }
}