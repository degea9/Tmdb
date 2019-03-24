package com.android.tmdb.movie.degea9.ui.moviedetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.tmdb.movie.degea9.data.database.entity.Review
import com.android.tmdb.movie.degea9.databinding.ReviewItemBinding
import com.amulyakhare.textdrawable.TextDrawable
import android.graphics.Color
import com.android.tmdb.movie.degea9.R


class ReviewAdapter(private val reviews: List<Review>) : RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        return ReviewViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.review_item,
                parent,
                false
            )
        );
    }

    override fun getItemCount(): Int = reviews.size

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.bind(reviews[position])
    }

    class ReviewViewHolder(val binding: ReviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(review: Review) {
            binding.review = review
            val drawable = TextDrawable.builder()
                .buildRoundRect(review.author.take(1).toUpperCase(), Color.RED, 100) // radius in px
            binding.firstLetter.setImageDrawable(drawable)
        }

    }
}