package com.android.tmdb.movie.degea9.data.api.model

import com.google.gson.annotations.SerializedName

/**
 * base api model for all responses
 */
abstract class BaseApiResponse {
    @SerializedName("total_pages")
    val totalPages: Int = 0;
    @SerializedName("page")
    val page: Int = 0;
    @SerializedName("total_results")
    val totalResults: Int = 0
}