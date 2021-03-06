package com.android.tmdb.movie.degea9.data.api.model

import com.android.tmdb.movie.degea9.data.api.DataResponse
import com.android.tmdb.movie.degea9.data.database.entity.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    val results: List<Movie>,

    @SerializedName("dates")
    val dates: Dates

) : BaseApiResponse(),DataResponse<List<Movie>> {
    override fun retrieveData(): List<Movie> = results


    data class Dates(
        @SerializedName("maximum")
        val maximum: String,
        @SerializedName("minimum")
        val minimum: String
    )
}