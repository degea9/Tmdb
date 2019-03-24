package com.android.tmdb.movie.degea9.util

import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.data.database.entity.Genre
import com.android.tmdb.movie.degea9.data.database.entity.MovieDetail
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
        requestOptions.placeholder(R.drawable.movie_placeholder).error(R.drawable.movie_placeholder)
        Glide.with(view.getContext()).setDefaultRequestOptions(requestOptions).load(URLUtils.buildBackDropUrl(path))
            .into(view)
    }

    //Picasso.get().load(URLUtils.buildBackDropUrl(url)).placeholder(R.drawable.movie_placeholder).into(view)
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

    //Picasso.get().load(URLUtils.buildBackDropUrl(url)).placeholder(R.drawable.movie_placeholder).into(view)
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

    //Picasso.get().load(URLUtils.buildBackDropUrl(url)).placeholder(R.drawable.movie_placeholder).into(view)
}

@BindingAdapter("setVisibility")
fun <T : Any> setVisibility(view: View, data: T?) {
    data?.let { view.visibility = View.GONE } ?: run { view.visibility = View.VISIBLE }
}

@BindingAdapter("setGenreName")
fun setGenreName(view: TextView, genreIds: List<Int>?) {
    genreIds?.let {
        view.setText(movieGenreMap.filter { genreIds.contains(it.key) }.values.toSet().joinToString())
    }
}

@BindingAdapter("setGenreName2")
fun setGenreName2(view: TextView, genre: List<Genre>?) {
    genre?.let {
        view.setText(genre.map { genre -> genre.name }.joinToString())
    }
}

@BindingAdapter("runtime")
fun setRuntime(view: TextView, movie: MovieDetail?) {
    movie?.let {
        view.setText(Utils.convertRuntime(movie))
    }
}

@BindingAdapter("setCertification")
fun setCertification(view: TextView, movie: MovieDetail?) {
    movie?.let {
        val certification = Utils.findCertification("US", movie)
        view.visibility = if (!TextUtils.isEmpty(certification)) {
            view.setText(certification)
            View.VISIBLE
        } else View.GONE
    }
}

@BindingAdapter("setDirectorText")
fun setDirectorText(view: TextView, movie: MovieDetail?) {
    movie?.let {
        view.text = movie.credits.crew.filter { "Director".equals(it.job) }.map { it.name }.joinToString()
    }
}
