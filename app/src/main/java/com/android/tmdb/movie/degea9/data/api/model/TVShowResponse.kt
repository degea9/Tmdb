package com.android.tmdb.movie.degea9.data.api.model

import com.android.tmdb.movie.degea9.data.database.entity.TVShow
import com.google.gson.annotations.SerializedName

data class TVShowResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("results")
    val movies: List<TVShow>

)