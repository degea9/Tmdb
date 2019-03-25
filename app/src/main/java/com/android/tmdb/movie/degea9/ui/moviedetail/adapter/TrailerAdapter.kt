package com.android.tmdb.movie.degea9.ui.moviedetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.data.database.entity.Video
import com.android.tmdb.movie.degea9.databinding.TrailerItemBinding

class TrailerAdapter(private val videos: List<Video>) : RecyclerView.Adapter<TrailerAdapter.TrailerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrailerViewHolder {
        return TrailerViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.trailer_item,
                parent,
                false
            )
        );
    }

    override fun getItemCount(): Int = videos.size

    override fun onBindViewHolder(holder: TrailerViewHolder, position: Int) {
        holder.bind(videos[position])
    }

    class TrailerViewHolder(val binding: TrailerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(video: Video) {
            binding.video = video
        }

    }
}