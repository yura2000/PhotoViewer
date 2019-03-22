package com.example.photoviewer.concrete_album

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.photoviewer.concrete_album.adapter.ConcreteAlbumRecyclerAdapter
import com.example.photoviewer.data.Photo
import kotlinx.android.synthetic.main.concrete_album_fragment.*

class ConcreteAlbumFragment : Fragment(), ConcreteAlbumContract.View {

    private var mPresenter: ConcreteAlbumContract.Presenter? = null
    private lateinit var callback: ConcreteAlbumClickListener
    private var mAlbumId: Int? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        callback = context as ConcreteAlbumClickListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var args = arguments
        val albumId = args?.getInt("ID", 0)

        mAlbumId = albumId
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.example.photoviewer.R.layout.concrete_album_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mPresenter?.getPhotos(mAlbumId)
    }

    override fun showPhotos(photos: List<Photo>?) {
        val photosRecyclerView = ConcreteAlbumRecyclerAdapter(photos!!)
        photosRecyclerView.onClickItem = (object : ConcreteAlbumClickListener {
            override fun onConcreteAlbumClicked(item: Photo) {
                callback.onConcreteAlbumClicked(item)
            }
        })
        val recyclerViewAlbums = concrete_album_recycler_view
        recyclerViewAlbums?.layoutManager = LinearLayoutManager(context)
        recyclerViewAlbums?.adapter = photosRecyclerView
    }

    override fun setPresenter(presenter: ConcreteAlbumContract.Presenter) {
        mPresenter = presenter
    }

    override fun showLoadError(resId: String?) {
        Toast.makeText(context, resId, Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
    }
}
