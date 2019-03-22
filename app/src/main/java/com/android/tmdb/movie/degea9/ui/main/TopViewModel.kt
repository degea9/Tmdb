package com.android.tmdb.movie.degea9.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.tmdb.movie.degea9.data.api.Result
import com.android.tmdb.movie.degea9.data.database.entity.Movie
import com.android.tmdb.movie.degea9.data.database.entity.TVShow
import com.android.tmdb.movie.degea9.data.movies.MovieRepository
import com.android.tmdb.movie.degea9.data.shows.ShowRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TopViewModel @Inject constructor(
    private val showRepository: ShowRepository,
    private val movieRepository: MovieRepository

) : ViewModel() {
    private val _onTheaterMovies = MutableLiveData<List<Movie>>()
    val onTheaterMovies: LiveData<List<Movie>>
        get() = _onTheaterMovies

    private val _broadcastingShows = MutableLiveData<List<TVShow>>()
    val broadcastingShows: LiveData<List<TVShow>>
        get() = _broadcastingShows


    init {


        viewModelScope.launch(Dispatchers.Default) {
            val results = showRepository.getBroadcastingShows()
            if (results is Result.Success)
                withContext(Dispatchers.Main) {
                    _broadcastingShows.value = results.data.take(3)
                }
            else Log.e("degea9", "api error ");
        }

        viewModelScope.launch(Dispatchers.Default) {
            val results = movieRepository.getNowPlayingMovies()
            if (results is Result.Success)
                withContext(Dispatchers.Main) {
                    _onTheaterMovies.value = results.data.take(3)
                }
            else Log.e("degea9", "api error ");
        }
    }

}