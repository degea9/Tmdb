package com.android.tmdb.movie.degea9.ui.top.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.data.database.entity.Movie
import com.android.tmdb.movie.degea9.databinding.TrendingItemBinding

class TrendingAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<TrendingAdapter.TrendingHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingHolder {
        return TrendingAdapter.TrendingHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.trending_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: TrendingHolder, position: Int) {
        holder.bind(movies[position])
    }


    class TrendingHolder(val binding: TrendingItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.movie = movie
        }
    }
}