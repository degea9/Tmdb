package com.android.tmdb.movie.degea9.ui.top.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.data.database.entity.TVShow

class OnTvAdapter(val tvshows:List<TVShow>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return OnTvShowHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.airing_tv_show,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int=tvshows.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

}

internal class OnTvShowHolder(itemView: View) : RecyclerView.ViewHolder(itemView)