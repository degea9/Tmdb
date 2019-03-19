package com.android.tmdb.movie.degea9.data.movies

import android.util.Log
import com.android.tmdb.movie.degea9.data.api.Result
import com.android.tmdb.movie.degea9.data.api.TmdbService
import com.android.tmdb.movie.degea9.data.api.model.MovieResponse
import com.android.tmdb.movie.degea9.data.database.entity.Movie
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
     * get trending movies
     */
    suspend fun getNowPlayingMovies(): Result<List<Movie>> {
        return try {
            val response = service.getPlayingMovies().await()
            getResult(response = response, onError = {
                Result.Error(
                    IOException("Error getting movies ${response.code()} ${response.message()}")
                )
            })
        } catch (e: Exception) {
            Result.Error(IOException("Error getting movies", e))
        }
    }

    /**
     * get trending movies
     */
    suspend fun getTrendingMovies(): Result<List<Movie>> {
        return try {
            val response = service.getTrendingMovies().await()
            getResult(response = response, onError = {
                Result.Error(
                    IOException("Error getting movies ${response.code()} ${response.message()}")
                )
            })
        } catch (e: Exception) {
            Result.Error(IOException("Error getting movies", e))
        }
    }

    /**
     * get result from response
     * @return Result data class in case success or onError will be called in other cases
     */
    private inline fun getResult(
        response: Response<MovieResponse>,
        onError: () -> Result.Error
    ): Result<List<Movie>> {
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                return Result.Success(body.results)
            }
        }
        return onError.invoke()
    }
}