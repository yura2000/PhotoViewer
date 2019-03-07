package com.example.photoviewer.mvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.photoviewer.adapter.RecyclerAdapter
import com.example.photoviewer.api.Album
import com.example.photoviewer.api.JsonPlaceHolderApi
import com.example.photoviewer.fragments.AlbumsFragment
import kotlinx.android.synthetic.main.fragment_albums.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity(), MainView {

    var frag1: Fragment = AlbumsFragment()
    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.photoviewer.R.layout.activity_main)

        presenter = MainPresenter(this, MainService())

        supportFragmentManager
            .beginTransaction()
            .add(com.example.photoviewer.R.id.fragment_container, frag1)
            .commit()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)

        val call = jsonPlaceHolderApi.albums

        call.enqueue(object : Callback<List<Album>> {
            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                val albums = response.body()

                val recyclerView = albumsRecyclerView
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerView.adapter = RecyclerAdapter(albums!!)
            }

            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                showApiError(t.message)
            }
        })
    }

    override val albumsRecyclerView: RecyclerView
        get() = albums_recycler_view

    override fun showAlbums() {
        presenter?.getAlbumsList()
    }

    override fun showApiError(resId: String?) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
    }
}
