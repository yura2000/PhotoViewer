package com.example.photoviewer.photo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast

import com.example.photoviewer.R
import com.example.photoviewer.concrete_album.ConcreteAlbumContract
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.photo_fragment.*

class PhotoFragment : Fragment(), PhotoContract.View {

    private var mPresenter: PhotoContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.photo_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        val photoId: Int? = args?.getInt("PHOTO_ID")

        mPresenter?.getPhotos(photoId)
    }

    override fun showPhoto(photoUrl: String?) {
        Picasso.get().load(photoUrl).into(image_view)
    }

    override fun setPresenter(presenter: PhotoContract.Presenter) {
        mPresenter = presenter
    }

    override fun showLoadError(resId: String?) {
        Toast.makeText(context, resId, Toast.LENGTH_LONG).show()
    }
}
