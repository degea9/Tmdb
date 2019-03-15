package com.android.tmdb.movie.degea9.ui.top

import androidx.lifecycle.ViewModel
import com.android.tmdb.movie.degea9.data.shows.ShowRepository

class TopViewModel(
    private val showRepository: ShowRepository,
    private val movieRepository: ShowRepository

) : ViewModel() {
    fun getBroadcastingTvShows() {
    }

}