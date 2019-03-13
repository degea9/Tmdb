package com.android.tmdb.movie.degea9.data.database.entity

import com.google.gson.annotations.SerializedName

data class TVShow(

    @SerializedName("original_name")
    val originalName: String,

    @SerializedName("name")
    val name: String,
    @SerializedName("popularity")
    val popularity: Float,
    @SerializedName("vote_count")
    val voteCount: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("vote_average")
    val voteAverage: Float,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val posterUrl: String


)