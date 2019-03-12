package movietube.tuandang.android.com.movietube.ui.api

import movietube.tuandang.android.com.movietube.api.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService{
    @GET("discover/movie")
    fun getMovie(): Call<ApiResponse>
}