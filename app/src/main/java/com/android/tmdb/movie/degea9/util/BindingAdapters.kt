package com.android.tmdb.movie.degea9.util

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.ui.PercentView
import com.android.tmdb.movie.degea9.util.GenreUtils.Companion.movieGenreMap
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso
import movietube.tuandang.android.com.movietube.util.URLUtils


@BindingAdapter("backdropPath")
fun setBackdropPath(view: ImageView, path: String?) {
    path?.let {
        val requestOptions = RequestOptions()
        requestOptions.placeholder(R.drawable.movide_placeholder).error(R.drawable.movide_placeholder)
        Glide.with(view.getContext()).setDefaultRequestOptions(requestOptions).load(URLUtils.buildBackDropUrl(path))
            .into(view)
    }

    //Picasso.get().load(URLUtils.buildBackDropUrl(url)).placeholder(R.drawable.movide_placeholder).into(view)
}

@BindingAdapter("posterPath")
fun setPosterPath(view: ImageView, path: String?) {
    path?.let {
        Picasso.get().load(URLUtils.buildPosterUrl(path)).fit().centerCrop()
            .placeholder(R.drawable.poster_placeholder).error(R.drawable.poster_placeholder).into(view)
//        val requestOptions = RequestOptions()
//        requestOptions.placeholder(R.drawable.poster_placeholder).error(R.drawable.poster_placeholder)
//        Glide.with(view.getContext()).setDefaultRequestOptions(requestOptions).load(URLUtils.buildPosterUrl(path))
//            .into(view)
    }

    //Picasso.get().load(URLUtils.buildBackDropUrl(url)).placeholder(R.drawable.movide_placeholder).into(view)
}

@BindingAdapter("percent")
fun setPercent(view: PercentView, voteAverage: Double?) {
    voteAverage?.let {
        view.percent = voteAverage.toFloat()
        view.visibility = View.VISIBLE
    }

}

@BindingAdapter("profile")
fun setProfile(view: ImageView, profilePath: String?) {
    profilePath?.let {
        val requestOptions = RequestOptions()
        requestOptions.placeholder(R.drawable.ic_profile).error(R.drawable.ic_profile)
        Glide.with(view.getContext()).setDefaultRequestOptions(requestOptions)
            .load(URLUtils.buildPosterUrl(profilePath))
            .into(view)
    }

    //Picasso.get().load(URLUtils.buildBackDropUrl(url)).placeholder(R.drawable.movide_placeholder).into(view)
}

@BindingAdapter("setVisibility")
fun <T : Any> setVisibility(view: View, data: T?) {
    data?.let { view.visibility = View.GONE } ?: run { view.visibility = View.VISIBLE }
}

@BindingAdapter("setGenreName")
fun <T : Any> setGenreName(view: TextView, genreIds: List<Int>?) {
    genreIds?.let {
        view.setText(movieGenreMap.filter { genreIds.contains(it.key) }.values.toSet().joinToString())
    }
}


