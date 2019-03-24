package com.android.tmdb.movie.degea9.ui.moviedetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.tmdb.movie.degea9.data.api.Result
import com.android.tmdb.movie.degea9.data.database.entity.MovieDetail
import com.android.tmdb.movie.degea9.data.database.entity.Review
import com.android.tmdb.movie.degea9.data.movies.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {
    private var isLoaded = false
    private var movieId = -1;
    private val _showLoading = MutableLiveData<Boolean>()
    val showLoading: LiveData<Boolean>
        get() = _showLoading
    private val _movieDetail = MutableLiveData<MovieDetail>()
    val movieDetail: LiveData<MovieDetail>
        get() = _movieDetail

    private val _reviews = MutableLiveData<List<Review>>()
    val reviews: LiveData<List<Review>>
        get() = _reviews

    init {


    }

    fun loadMovie(id: Int) {
        movieId = id
        if (!isLoaded) {
            viewModelScope.launch(Dispatchers.Default) {
                _showLoading.postValue(true)
                val results = movieRepository.getMovieDetail(id)
                when (results) {
                    is Result.Success -> withContext(Dispatchers.Main) {
                        isLoaded = true
                        _showLoading.value = false
                        _movieDetail.value = results.data
                    }

                    is Result.Error -> {
                        _showLoading.postValue(false)
                        Log.e("degea9", "MovieDetailViewModel load movie api error ");
                    }
                }
            }
        }
    }

    /**
     * get reviews
     */
    fun loadReview() {
        if (movieId != -1) {
            viewModelScope.launch(Dispatchers.Default) {
                val results = movieRepository.getReviews(movieId)
                if (results is Result.Success)
                    withContext(Dispatchers.Main) {
                        _reviews.value = results.data
                    }
                else Log.e("degea9", "api error ");
            }
        }
    }

}