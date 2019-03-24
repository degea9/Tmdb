package com.android.tmdb.movie.degea9.data.api.model

import com.android.tmdb.movie.degea9.data.api.DataResponse
import com.android.tmdb.movie.degea9.data.database.entity.Review

data class ReviewResponse(
    val id: Int,
    val results: List<Review>
):BaseApiResponse(),DataResponse<List<Review>> {
    override fun retrieveData(): List<Review> = results
}