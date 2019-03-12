package movietube.tuandang.android.com.movietube.ui.api

import kotlinx.coroutines.Deferred
import movietube.tuandang.android.com.movietube.api.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface TmdbService {
    @GET("discover/movie")
    fun getMovie(): Deferred<Response<ApiResponse>>
}