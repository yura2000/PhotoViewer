package com.example.photoviewer.concrete_album

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.photoviewer.R
import com.example.photoviewer.data.source.remote.PhotosRemoteDataSource

class ConcreteAlbumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.concrete_album_activity)

        val fragment = ConcreteAlbumFragment()

        val repository = PhotosRemoteDataSource()

        supportFragmentManager
            .beginTransaction()
            .replace(com.example.photoviewer.R.id.concrete_album_frag, fragment)
            .addToBackStack(null)
            .commit()

        val presenter = ConcreteAlbumPresenter(fragment, repository)
    }
}
