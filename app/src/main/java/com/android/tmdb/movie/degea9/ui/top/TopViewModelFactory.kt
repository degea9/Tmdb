package com.android.tmdb.movie.degea9.ui.top

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.tmdb.movie.degea9.data.shows.ShowRepository

/**
 * Factory for creating [StoryViewModel] with args.
 */
class TopViewModelFactory(
    private val showRepository: ShowRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass != TopViewModel::class.java) {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
        return TopViewModel(
            showRepository
        ) as T
    }
}
