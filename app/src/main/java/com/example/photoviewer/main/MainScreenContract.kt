package com.example.photoviewer.main

interface MainScreenContract {
    interface View {
        fun startAlbumsFragment()
        fun startConcreteAlbumFragment(itemId: Int)
        fun startPhotoFragment(itemId: Int)
    }
}