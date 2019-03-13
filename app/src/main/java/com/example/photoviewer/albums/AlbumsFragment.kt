package com.example.photoviewer.albums

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.photoviewer.R
import com.example.photoviewer.albums.adapter.AlbumsRecyclerAdapter
import com.example.photoviewer.data.Album
import kotlinx.android.synthetic.main.albums_fragment.*

class AlbumsFragment : Fragment(), AlbumsContract.View {

    private var mPresenter: AlbumsContract.Presenter? = null

    private lateinit var callback: AlbumsClickListener

    private val TAG = "myLogs"

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        callback = context as AlbumsClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setPresenter(presenter: AlbumsContract.Presenter) {
        mPresenter = presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter?.getAlbums()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.albums_fragment, container, false)
    }

    override fun showConcreteAlbumActivity(pos: Int?) {

    }

    override fun showAlbums(albums: List<Album>?) {
        val albumsRecyclerView = AlbumsRecyclerAdapter(albums!!)
        albumsRecyclerView.onClickItem = (object : AlbumsClickListener {
            override fun onAlbumsClicked(view: View, item: Album) {
                callback.onAlbumsClicked(view, item)
            }
        })
        val recyclerViewAlbums = albums_recycler_view
        recyclerViewAlbums?.layoutManager = LinearLayoutManager(context)
        recyclerViewAlbums?.adapter = albumsRecyclerView

    }

    override fun showLoadError(resId: String?) {
        Toast.makeText(context, resId, Toast.LENGTH_LONG).show()
    }
}
