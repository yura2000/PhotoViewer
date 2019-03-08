package com.example.photoviewer.mvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.photoviewer.adapter.AlbumRecyclerAdapter
import com.example.photoviewer.adapter.PhotoRecyclerAdapter
import com.example.photoviewer.api.Album
import com.example.photoviewer.api.Photo
import com.example.photoviewer.fragments.AlbumsFragment
import com.example.photoviewer.fragments.ConcreteAlbumFragment
import kotlinx.android.synthetic.main.fragment_albums.*
import kotlinx.android.synthetic.main.fragment_concrete_album.*


class MainActivity : AppCompatActivity(), MainView {

    var frag1: Fragment = AlbumsFragment()
    var frag2: Fragment = ConcreteAlbumFragment()
    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.photoviewer.R.layout.activity_main)

        presenter = MainPresenter(this, MainService())

        supportFragmentManager
            .beginTransaction()
            .add(com.example.photoviewer.R.id.fragment_container, frag1)
            .commit()

        presenter?.getAlbumsList()
    }

    override val albumsRecyclerView: RecyclerView
        get() = albums_recycler_view

    override fun showAlbums(albums: List<Album>) {
        val recyclerViewAlbums = albums_recycler_view
        recyclerViewAlbums?.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerViewAlbums?.adapter = AlbumRecyclerAdapter(albums, presenter)
    }

    override fun setAlbumIdForPhotos(albumId: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(com.example.photoviewer.R.id.fragment_container, frag2)
            .addToBackStack(null)
            .commit()

        presenter?.getPhotosList(albumId + 1)
    }

    override fun showPhotos(photos: List<Photo>) {
        Toast.makeText(this, "Blyat!", Toast.LENGTH_SHORT).show()

        val recyclerViewPhotos = photos_recycler_view
        recyclerViewPhotos?.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerViewPhotos?.adapter = PhotoRecyclerAdapter(photos, presenter)
    }

    override fun showApiError(resId: String?) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
    }
}
