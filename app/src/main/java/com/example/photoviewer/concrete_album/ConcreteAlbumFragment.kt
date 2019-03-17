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
    val args = arguments
    val albumId: Int? = args?.getInt("ALBUM_ID", 0)

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        callback = context as ConcreteAlbumClickListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

        mPresenter?.getPhotos(albumId)
    }

    override fun showPhotos(photos: List<Photo>?) {
        var photosRecyclerView = ConcreteAlbumRecyclerAdapter(photos!!)
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

    override fun showLoadError(resId: String?) {
        Toast.makeText(context, resId, Toast.LENGTH_LONG).show()
    }
}
