package com.android.tmdb.movie.degea9.data.shows

import com.android.tmdb.movie.degea9.data.api.Result
import com.android.tmdb.movie.degea9.data.api.TmdbService
import com.android.tmdb.movie.degea9.data.api.model.TVShowResponse
import com.android.tmdb.movie.degea9.data.database.entity.TVShow
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShowRemoteDataSource @Inject constructor(val service: TmdbService) {

    /**
     * get on the air shows
     */
    suspend fun getBroadcastingShows(): Result<List<TVShow>> {
        return try {
            val response = service.getBroadcastingShows().await()
            getResult(response = response, onError = {
                Result.Error(
                    IOException("Error getting shows ${response.code()} ${response.message()}")
                )
            })
        } catch (e: Exception) {
            Result.Error(IOException("Error getting shows", e))
        }
    }

    /**
     * get result from response
     * @return Result data class in case success or onError will be called in other cases
     */
    private inline fun getResult(
        response: Response<TVShowResponse>,
        onError: () -> Result.Error
    ): Result<List<TVShow>> {
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                return Result.Success(body.results)
            }
        }
        return onError.invoke()
    }

}