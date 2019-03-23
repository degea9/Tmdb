package com.android.tmdb.movie.degea9.ui.main.movie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.data.database.entity.Movie
import com.android.tmdb.movie.degea9.data.database.entity.TVShow
import com.android.tmdb.movie.degea9.databinding.MovieItemBinding

internal typealias OnClick = (movie: Movie) -> Unit

class TabMovieAdapter(private var movies: List<Movie>,private val onClick: OnClick) : RecyclerView.Adapter<TabMovieAdapter.MovieHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        return MovieHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.movie_item,
                parent,
                false
            )
        )
    }



    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(movies[position])
            View.OnClickListener { movies[position].let { onClick(it) } }.apply {
                holder.setOnClick(this)
            }
    }

    class MovieHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.movie = movie
        }

        fun setOnClick(listener: View.OnClickListener){
            binding.root.setOnClickListener(listener)
        }
    }
}

