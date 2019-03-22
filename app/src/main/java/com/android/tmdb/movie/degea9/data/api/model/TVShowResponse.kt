package com.android.tmdb.movie.degea9.data.api.model

import com.android.tmdb.movie.degea9.data.api.DataResponse
import com.android.tmdb.movie.degea9.data.database.entity.TVShow
import com.google.gson.annotations.SerializedName

/**
 * a model class for tv shows
 */
data class TVShowResponse(
    @SerializedName("results")
    val results: List<TVShow>

) : BaseApiResponse(),DataResponse<List<TVShow>> {
    override fun retrieveData(): List<TVShow> = results
}