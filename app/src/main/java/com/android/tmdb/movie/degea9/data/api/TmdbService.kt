package com.android.tmdb.movie.degea9.data.api

import com.android.tmdb.movie.degea9.data.api.model.MovieResponse
import com.android.tmdb.movie.degea9.data.api.model.TVShowResponse
import com.android.tmdb.movie.degea9.data.database.entity.Credit
import com.android.tmdb.movie.degea9.data.database.entity.MovieDetail
import com.android.tmdb.movie.degea9.data.database.entity.TvShowDetail
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbService {

    /**
     * get tv show on the air
     */
    @GET("tv/on_the_air")
    fun getBroadcastingShows(
        @Query("language") language: String? = "en-US",
        @Query("page") page: Int? = 1
    ): Deferred<Response<TVShowResponse>>

    /**
     * get popular tv show
     */
    @GET("tv/popular")
    fun getPopularShows(
        @Query("language") language: String? = "en-US",
        @Query("page") page: Int? = 1
    ): Deferred<Response<TVShowResponse>>

    /**
     * get top rated tv show
     */
    @GET("tv/top_rated")
    fun getTopRatedShows(
        @Query("language") language: String? = "en-US",
        @Query("page") page: Int? = 1
    ): Deferred<Response<TVShowResponse>>

    /**
     * get airing today tv show
     */
    @GET("tv/airing_today")
    fun getAiringTodayShows(
        @Query("language") language: String? = "en-US",
        @Query("page") page: Int? = 1
    ): Deferred<Response<TVShowResponse>>

    /**
     * discover tv shows
     */
    @GET("discover/tv")
    fun getDiscoverShows(
        @Query("language") language: String? = "en-US",
        @Query("sort_by") sort_by: String? = "popularity.desc",
        @Query("page") page: Int? = 1,
        @Query("timezone") timezone: String? = "America/New_York",
        @Query("include_null_first_air_dates") include_null_first_air_dates: Boolean? = false
    ): Deferred<Response<TVShowResponse>>

    /**
     * get playing movies
     */
    @GET("movie/now_playing")
    fun getPlayingMovies(
        @Query("language") language: String? = "en-US",
        @Query("page") page: Int? = 1,
        @Query("region") region: String? = null
    ): Deferred<Response<MovieResponse>>

    /**
     * get popular movies
     */
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("language") language: String? = "en-US",
        @Query("page") page: Int? = 1,
        @Query("region") region: String? = null
    ): Deferred<Response<MovieResponse>>

    /**
     * get top rated movies
     */
    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("language") language: String? = "en-US",
        @Query("page") page: Int? = 1,
        @Query("region") region: String? = null
    ): Deferred<Response<MovieResponse>>

    /**
     * get up coming movies
     */
    @GET("movie/upcoming")
    fun getUpComingMovies(
        @Query("language") language: String? = "en-US",
        @Query("page") page: Int? = 1,
        @Query("region") region: String? = null
    ): Deferred<Response<MovieResponse>>

    /**
     * get latest movies
     */
    @GET("movie/latest")
    fun getLatestMovies(
        @Query("language") language: String? = "en-US"
    ): Deferred<Response<MovieResponse>>

    /**
     * discover movies
     */
    @GET("discover/movie")
    fun getDiscoverMovies(
        @Query("language") language: String? = "en-US",
        @Query("sort_by") sort_by: String? = "popularity.desc",
        @Query("include_adult") include_adult: Boolean? = false,
        @Query("include_video") include_video: Boolean? = false,
        @Query("page") page: Int? = 1
    ): Deferred<Response<TVShowResponse>>

    /**
     * get trending movies in time window
     */
    @GET("trending/movie/day")
    fun getTrendingMovies(
    ): Deferred<Response<MovieResponse>>

    /**
     * get Tv show detail
     */
    @GET("tv/{tv_id}")
    fun getShowDetail(
        @Path("tv_id") tv_id: Int,
        @Query("language") language: String? = "en-US"
    ): Deferred<Response<TvShowDetail>>

    /**
     * get movie  detail
     */
    @GET("movie/{movie_id}")
    fun getMovieDetail(
        @Path("movie_id") movie_id: Int,
        @Query("language") language: String? = "en-US",
        @Query("append_to_response") append_to_response: String? = null
    ): Deferred<Response<MovieDetail>>

    /**
     * get Tv show credit
     */
    @GET("tv/{tv_id}/credits")
    fun getCredit(
        @Path("tv_id") tv_id: Int,
        @Query("language") language: String? = "en-US"
    ): Deferred<Response<Credit>>

    companion object {
        val BASE_URL = "https://api.themoviedb.org/3/"
        val NOW_PLAYING_MOVIE = 0
        val TRENDING_MOVIE = 1
        val POPULAR_MOVIE = 2
        val TOP_RATED_MOVIE = 3
        val UP_COMING_MOVIE = 4
        val LATEST_MOVIE = 5
    }


}