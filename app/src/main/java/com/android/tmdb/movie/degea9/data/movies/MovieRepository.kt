package com.android.tmdb.movie.degea9.data.movies

import com.android.tmdb.movie.degea9.data.api.Result
import com.android.tmdb.movie.degea9.data.database.entity.Movie
import com.android.tmdb.movie.degea9.data.database.entity.TVShow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val remoteDataSource: MovieRemoteDataSource){


    /**
     * get now playing movies
     */
    suspend fun getNowPlayingMovies(): Result<List<Movie>> {
        return remoteDataSource.getNowPlayingMovies()
    }

    /**
     * get tv shows on the air
     */
    suspend fun getTrendingMovies(): Result<List<Movie>> {
        return remoteDataSource.getTrendingMovies()
    }
}