package com.example.photoviewer.albums

import android.content.Context
import android.nfc.Tag
import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.photoviewer.albums.adapter.AlbumsRecyclerAdapter
import com.example.photoviewer.data.Album
import kotlinx.android.synthetic.main.albums_fragment.*
import android.support.v7.widget.RecyclerView
import android.util.Log


class AlbumsFragment : Fragment(), AlbumsContract.View {

    private var mPresenter: AlbumsContract.Presenter? = null
    private lateinit var callback: AlbumsClickListener
    private val KEY_RECYCLER_STATE = "recycler_state"
    private var mListState: Parcelable? = null
    var recyclerViewAlbums: RecyclerView? = null
    var currentVisiblePosition: Int? = null

    private val TAG = "myLogs"

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        callback = context as AlbumsClickListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.example.photoviewer.R.layout.albums_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter?.getAlbums()
    }

    override fun setPresenter(presenter: AlbumsContract.Presenter) {
        mPresenter = presenter
    }

    override fun showAlbums(albums: List<Album>?) {
        val albumsRecyclerView = AlbumsRecyclerAdapter(albums!!)
        albumsRecyclerView.listener = (object : AlbumsClickListener {
            override fun onAlbumsClicked(item: Album) {
                callback.onAlbumsClicked(item)
            }
        })
        recyclerViewAlbums = albums_recycler_view
        recyclerViewAlbums?.layoutManager = LinearLayoutManager(context)
        recyclerViewAlbums?.adapter = albumsRecyclerView
    }

    override fun showLoadError(resId: String?) {
        Toast.makeText(context, resId, Toast.LENGTH_LONG).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        mListState = recyclerViewAlbums?.layoutManager?.onSaveInstanceState()
        outState.putParcelable(KEY_RECYCLER_STATE, mListState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(savedInstanceState != null)
            mListState = savedInstanceState.getParcelable(KEY_RECYCLER_STATE)
    }

    override fun onResume() {
        super.onResume()

        if (mListState != null)
            recyclerViewAlbums?.layoutManager?.onRestoreInstanceState(mListState)
//        currentVisiblePosition?.let { recyclerViewAlbums?.layoutManager?.scrollToPosition(it) }
//        currentVisiblePosition = 0
    }

    override fun onPause() {
        super.onPause()

        currentVisiblePosition = (recyclerViewAlbums?.layoutManager as? LinearLayoutManager)
            ?.findFirstCompletelyVisibleItemPosition()
    }




}
