package com.android.tmdb.movie.degea9.data.api.model

import com.android.tmdb.movie.degea9.data.api.DataResponse
import com.android.tmdb.movie.degea9.data.database.entity.Video
import com.google.gson.annotations.SerializedName

data class VideoResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("results")
    val results: List<Video>
):DataResponse<List<Video>> {
    override fun retrieveData() = results


}