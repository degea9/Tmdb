package com.android.tmdb.movie.degea9.data.database.entity

import androidx.room.Entity
import com.android.tmdb.movie.degea9.data.api.DataResponse
import com.google.gson.annotations.SerializedName

data class TVShow(

    @SerializedName("original_name")
    val originalName: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("name")
    val name: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("origin_country")
    val originCountry: List<String>,
    @SerializedName("vote_count")
    val voteCount: Int,
    @SerializedName("first_air_date")
    val firstAirDate: String,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String

):DataResponse<TVShow> {
    override fun retrieveData(): TVShow = this
}