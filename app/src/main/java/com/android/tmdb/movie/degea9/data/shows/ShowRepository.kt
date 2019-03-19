package com.android.tmdb.movie.degea9.data.shows

import com.android.tmdb.movie.degea9.data.api.Result
import com.android.tmdb.movie.degea9.data.database.entity.TVShow
import com.android.tmdb.movie.degea9.data.database.entity.TvShowDetail
import javax.inject.Inject
import javax.inject.Singleton

/**
 * repository tv shows from various data sources
 */

// TODO: add local data source
@Singleton
class ShowRepository @Inject constructor(private val remoteDataSource: ShowRemoteDataSource) {

    /**
     * get tv shows on the air
     */
    suspend fun getBroadcastingShows(): Result<List<TVShow>> {
        return remoteDataSource.getBroadcastingShows()
    }

    suspend fun getShowDetail(id:Int):Result<TvShowDetail>{
        return remoteDataSource.getShowDetail(id)
    }
}