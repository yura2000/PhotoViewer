package com.example.photoviewer.mvp

import com.example.photoviewer.adapter.RecyclerAdapter
import com.example.photoviewer.api.Album
import com.example.photoviewer.api.JsonPlaceHolderApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainPresenter(private val view: MainView, private val service: MainService) {

    fun getAlbumsList() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)

        val call = jsonPlaceHolderApi.albums

        call.enqueue(object : Callback<List<Album>> {
            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                val albums = response.body()

                val recyclerView = view.albumsRecyclerView
            //    recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = RecyclerAdapter(albums!!)
            }

            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                view.showApiError(t.message)
            }
        })
    }
}