package com.fillooow.shadrin.ui

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fillooow.shadrin.R

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .override(1000, 1000)
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(imgView)
    }
}