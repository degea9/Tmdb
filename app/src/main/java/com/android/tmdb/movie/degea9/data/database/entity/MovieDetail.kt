package com.android.tmdb.movie.degea9.data.database.entity

import com.android.tmdb.movie.degea9.data.api.DataResponse
import com.android.tmdb.movie.degea9.data.api.model.VideoResponse

data class MovieDetail(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: Any,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val release_date: String,
    val release_dates: ReleaseDates,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int,
    val credits: Credit,
    val videos: VideoResponse
) : DataResponse<MovieDetail> {
    override fun retrieveData(): MovieDetail = this
}