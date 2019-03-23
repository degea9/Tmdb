package com.android.tmdb.movie.degea9.ui.main.tvshow

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.tmdb.movie.degea9.data.api.Result
import com.android.tmdb.movie.degea9.data.database.entity.TVShow
import com.android.tmdb.movie.degea9.data.movies.MovieRepository
import com.android.tmdb.movie.degea9.data.shows.ShowRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TVShowViewModel @Inject constructor(
    private val showRepository: ShowRepository
) : ViewModel() {

    private val _trendingShows = MutableLiveData<List<TVShow>>()
    val trendingShows: LiveData<List<TVShow>>
        get() = _trendingShows


    init {


        viewModelScope.launch(Dispatchers.Default) {
            val results = showRepository.getBroadcastingShows()
            if (results is Result.Success)
                withContext(Dispatchers.Main) {
                    _trendingShows.value = results.data
                }
            else Log.e("degea9", "api error ");
        }

    }

}