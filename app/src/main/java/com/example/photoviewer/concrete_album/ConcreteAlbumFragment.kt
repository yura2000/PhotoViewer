package com.example.photoviewer.concrete_album

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.photoviewer.R
import com.example.photoviewer.concrete_album.adapter.ConcreteAlbumRecyclerAdapter
import com.example.photoviewer.data.Photo
import kotlinx.android.synthetic.main.concrete_album_fragment.*

class ConcreteAlbumFragment : Fragment(), ConcreteAlbumContract.View {

    private var mPresenter: ConcreteAlbumContract.Presenter? = null

    private lateinit var callback: ConcreteAlbumClickListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val pos = intent.getStringExtra("ALBUM_ID")
        val args = arguments

        val albumId: Int? = args?.getInt("ALBUM_ID", 0)

        mPresenter?.getPhotos(albumId)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        callback = context as ConcreteAlbumClickListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.concrete_album_fragment, container, false)
    }

    override fun showPhotos(photos: List<Photo>?) {
        val photosRecyclerView = ConcreteAlbumRecyclerAdapter(photos!!)
        photosRecyclerView.onClickItem = (object : ConcreteAlbumClickListener {
            override fun onConcreteAlbumClicked(view: View, item: Photo) {
                callback.onConcreteAlbumClicked(view, item)
            }
        })
        val recyclerViewAlbums = concrete_album_recycler_view
        recyclerViewAlbums?.layoutManager = LinearLayoutManager(context)
        recyclerViewAlbums?.adapter = photosRecyclerView
    }

    override fun setPresenter(presenter: ConcreteAlbumContract.Presenter) {
        mPresenter = presenter
    }

    override fun showPhotoActivity(photoId: Int?) {

        //startActivity(intent)
    }

    override fun showLoadError(resId: String?) {
        Toast.makeText(context, resId, Toast.LENGTH_LONG).show()
    }
}
