package com.android.tmdb.movie.degea9.ui.moviedetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.data.database.entity.Cast
import com.android.tmdb.movie.degea9.databinding.CastItemBinding

class CastAdapter(private val actors: List<Cast>) : RecyclerView.Adapter<CastAdapter.CastViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        return CastViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.cast_item,
                parent,
                false
            )
        );
    }

    override fun getItemCount(): Int = actors.size

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        holder.bind(actors[position])
    }

    class CastViewHolder(val binding: CastItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(actor: Cast) {
            binding.cast = actor
        }

    }
}