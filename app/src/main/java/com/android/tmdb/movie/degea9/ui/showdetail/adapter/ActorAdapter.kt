package com.android.tmdb.movie.degea9.ui.showdetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.data.database.entity.Cast
import com.android.tmdb.movie.degea9.databinding.ActorItemBinding

class ActorAdapter(private val actors: List<Cast>) : RecyclerView.Adapter<ActorAdapter.ActorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        return ActorViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.actor_item,
                parent,
                false
            )
        );
    }

    override fun getItemCount(): Int = actors.size

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.bind(actors[position])
    }

    class ActorViewHolder(val binding: ActorItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(actor: Cast) {
            binding.cast = actor
        }

    }
}