package com.example.photoviewer.photo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.photoviewer.R
import com.example.photoviewer.concrete_album.ConcreteAlbumFragment
import com.example.photoviewer.concrete_album.ConcreteAlbumPresenter
import com.example.photoviewer.data.source.remote.PhotoRemoteDataSource
import com.example.photoviewer.data.source.remote.PhotosRemoteDataSource

class PhotoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.photo_activity)


        val fragment = PhotoFragment()

        val repository = PhotoRemoteDataSource()

        supportFragmentManager
            .beginTransaction()
            .replace(com.example.photoviewer.R.id.photo_frag, fragment)
            .addToBackStack(null)
            .commit()

        val presenter = PhotoPresenter(fragment, repository)
    }
}
