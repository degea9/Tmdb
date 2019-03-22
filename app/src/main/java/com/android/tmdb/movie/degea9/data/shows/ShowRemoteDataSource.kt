package com.android.tmdb.movie.degea9.data.shows

import com.android.tmdb.movie.degea9.data.api.Result
import com.android.tmdb.movie.degea9.data.api.TmdbService
import com.android.tmdb.movie.degea9.data.database.entity.Credit
import com.android.tmdb.movie.degea9.data.database.entity.TVShow
import com.android.tmdb.movie.degea9.data.database.entity.TvShowDetail
import com.android.tmdb.movie.degea9.util.safeApiCall
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShowRemoteDataSource @Inject constructor(val service: TmdbService) {

    /**
     * get tv show detail
     */
    suspend fun getCredit(id: Int): Result<Credit> =
        safeApiCall(service.getCredit(id), errorMessage = "Unable to get credit")


    /**
     * get tv show detail
     */
    suspend fun getShowDetail(id: Int): Result<TvShowDetail> =
        safeApiCall(service.getShowDetail(id), errorMessage = "Unable to get show detail")


    /**
     * get on the air shows
     */
    suspend fun getBroadcastingShows(): Result<List<TVShow>> =
        safeApiCall(service.getBroadcastingShows(), errorMessage = "Unable to get show on the air")
}


