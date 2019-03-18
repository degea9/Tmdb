package com.android.tmdb.movie.degea9.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import movietube.tuandang.android.com.movietube.util.URLUtils


@BindingAdapter("imageUrl")
fun setImageUrl(view: ImageView, url: String) {
    Glide.with(view.getContext()).load(URLUtils.buildPosterUrl(url)).into(view)
}