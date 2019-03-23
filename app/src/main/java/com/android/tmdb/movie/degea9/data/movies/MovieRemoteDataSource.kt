package com.android.tmdb.movie.degea9.data.movies

import android.util.Log
import com.android.tmdb.movie.degea9.data.api.Result
import com.android.tmdb.movie.degea9.data.api.TmdbService
import com.android.tmdb.movie.degea9.data.api.model.MovieResponse
import com.android.tmdb.movie.degea9.data.database.entity.Movie
import com.android.tmdb.movie.degea9.data.database.entity.MovieDetail
import com.android.tmdb.movie.degea9.util.safeApiCall
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * remote data source for movies
 */
@Singleton
class MovieRemoteDataSource @Inject constructor(val service: TmdbService) {

    /**
     * get nowp laying movies
     */
    suspend fun getNowPlayingMovies(): Result<List<Movie>> =
        safeApiCall(service.getPlayingMovies(), errorMessage = "Error getting now playing movies")

    /**
     * get trending movies
     */
    suspend fun getTrendingMovies(): Result<List<Movie>> =
        safeApiCall(service.getTrendingMovies(), errorMessage = "Error getting trending movies")

    /**
     * get popular movies
     */
    suspend fun getPopularMovies(): Result<List<Movie>> =
        safeApiCall(service.getPopularMovies(), errorMessage = "Error getting popular movies")

    /**
     * get top rated movies
     */
    suspend fun getTopRatedMovies(): Result<List<Movie>> =
        safeApiCall(service.getTopRatedMovies(), errorMessage = "Error getting top rated movies")

    /**
     * get top rated movies
     */
    suspend fun getUpComingMovies(): Result<List<Movie>> =
        safeApiCall(service.getUpComingMovies(), errorMessage = "Error getting up coming movies")

    /**
     * get the latest movies
     */
    suspend fun getLatestMovies(): Result<List<Movie>> =
        safeApiCall(service.getLatestMovies(), errorMessage = "Error getting latest movies")

    /**
     * get movie detail
     */
    suspend fun getMovieDetail(id:Int): Result<MovieDetail> =
        safeApiCall(service.getMovieDetail(id), errorMessage = "Error getting movie detail")


}