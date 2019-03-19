package com.android.tmdb.movie.degea9.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.android.tmdb.movie.degea9.R
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import movietube.tuandang.android.com.movietube.util.URLUtils
import com.bumptech.glide.request.RequestOptions


@BindingAdapter("imageUrl")

fun setImageUrl(view: ImageView, url: String) {
    val requestOptions = RequestOptions()
    requestOptions.placeholder(R.drawable.movide_placeholder).error(R.drawable.movide_placeholder)
    Glide.with(view.getContext()).setDefaultRequestOptions(requestOptions).load(URLUtils.buildPosterUrl(url)).into(view)
    //Picasso.get().load(URLUtils.buildPosterUrl(url)).placeholder(R.drawable.movide_placeholder).into(view)
}