package com.example.photoviewer.albums

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.photoviewer.R
import com.example.photoviewer.data.source.remote.AlbumsRemoteDataSource

class AlbumsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.albums_activity)

        val fragment = AlbumsFragment()

        val repository = AlbumsRemoteDataSource()

        supportFragmentManager
            .beginTransaction()
            .add(com.example.photoviewer.R.id.albums_frag, fragment)
            .commit()

        val presenter = AlbumsPresenter(fragment, repository)
    }
}
