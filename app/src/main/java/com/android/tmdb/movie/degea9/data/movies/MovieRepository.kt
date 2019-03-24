package com.android.tmdb.movie.degea9.data.movies

import com.android.tmdb.movie.degea9.data.api.Result
import com.android.tmdb.movie.degea9.data.api.TmdbService.Companion.NOW_PLAYING_MOVIE
import com.android.tmdb.movie.degea9.data.api.TmdbService.Companion.POPULAR_MOVIE
import com.android.tmdb.movie.degea9.data.api.TmdbService.Companion.TOP_RATED_MOVIE
import com.android.tmdb.movie.degea9.data.api.TmdbService.Companion.TRENDING_MOVIE
import com.android.tmdb.movie.degea9.data.api.TmdbService.Companion.UP_COMING_MOVIE
import com.android.tmdb.movie.degea9.data.database.entity.Movie
import com.android.tmdb.movie.degea9.data.database.entity.MovieDetail
import com.android.tmdb.movie.degea9.data.database.entity.Review
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val remoteDataSource: MovieRemoteDataSource) {

    /**
     * get movie depend on category
     */
    suspend fun getMovies(category: Int): Result<List<Movie>> {
        return when (category) {
            NOW_PLAYING_MOVIE -> remoteDataSource.getNowPlayingMovies()
            TRENDING_MOVIE -> remoteDataSource.getTrendingMovies()
            POPULAR_MOVIE -> remoteDataSource.getPopularMovies()
            TOP_RATED_MOVIE -> remoteDataSource.getTopRatedMovies()
            UP_COMING_MOVIE -> remoteDataSource.getUpComingMovies()
            else -> remoteDataSource.getLatestMovies()
        }
    }


    suspend fun getMovieDetail(movieId: Int): Result<MovieDetail> {
        return remoteDataSource.getMovieDetail(movieId)
    }

    suspend fun getReviews(movieId: Int): Result<List<Review>> {
        return remoteDataSource.getMovieReview(movieId)
    }
}