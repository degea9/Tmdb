package com.android.tmdb.movie.degea9.data.api

import com.android.tmdb.movie.degea9.data.api.model.TVShowResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbService {
//    @GET("discover/movie")
//    fun getMovie(): Deferred<Response<ApiResponse>>

    @GET("tv/on_the_air")
    fun getBroadcastingTv(@Query("language") language: String = "en-US", @Query("page") page: Int = 1): Deferred<Response<TVShowResponse>>

    companion object {
        val BASE_URL = "https://api.themoviedb.org/3/"
    }
}