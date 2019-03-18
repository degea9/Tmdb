package com.android.tmdb.movie.degea9.ui.top.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.data.database.entity.TVShow
import com.android.tmdb.movie.degea9.databinding.AiringTvShowBinding

class OnTvAdapter(private var tvshows: List<TVShow>) : RecyclerView.Adapter<OnTvAdapter.OnTvShowHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnTvAdapter.OnTvShowHolder {
        return OnTvShowHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.airing_tv_show,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = tvshows.size

    override fun onBindViewHolder(holder: OnTvShowHolder, position: Int) {
        holder.bind(tvshows[position])
    }

//    fun update(items: List<TVShow>) {
//        this.tvshows = items
//        notifyDataSetChanged()
//    }


    class OnTvShowHolder(val binding: AiringTvShowBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tvshow: TVShow) {
            binding.show = tvshow
        }
    }
}

