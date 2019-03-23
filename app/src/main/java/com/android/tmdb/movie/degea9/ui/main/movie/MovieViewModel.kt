package com.android.tmdb.movie.degea9.ui.main.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.tmdb.movie.degea9.data.api.Result
import com.android.tmdb.movie.degea9.data.database.entity.Movie
import com.android.tmdb.movie.degea9.data.movies.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    private val movieRepository: MovieRepository

) : ViewModel() {
    private val viewModelMap = HashMap<Int, MutableLiveData<List<Movie>>>()
    private val loadingMap = HashMap<Int, MutableLiveData<Boolean>>()


    /**
     * get movies based on category:now playing,trending...
     */
    fun getMovies(category: Int): LiveData<List<Movie>> {
        var movieLiveData: MutableLiveData<List<Movie>>?
        var loadingLiveData: MutableLiveData<Boolean>?
        if (viewModelMap.containsKey(category)) {
            movieLiveData = viewModelMap.get(category)
            loadingLiveData = loadingMap.get(category)
        } else {
            movieLiveData = MutableLiveData()
            loadingLiveData = MutableLiveData()
            viewModelMap.put(category, movieLiveData)
            loadingMap.put(category, loadingLiveData)
            loadingLiveData.value = true
            viewModelScope.launch(Dispatchers.Default) {
                val results = movieRepository.getMovies(category)
                loadingLiveData?.postValue(false)
                if (results is Result.Success)
                    withContext(Dispatchers.Main) {
                        movieLiveData.value = results.data
                    }
                else Log.e("degea9", "api error ");
            }
        }
        return movieLiveData!!
    }

    fun getLoadingStatus(category: Int) = loadingMap.get(category)

    /**
     * refresh
     */
    fun reFresh(category: Int) {
        val liveData = viewModelMap.get(category)
        liveData?.let {
            viewModelScope.launch(Dispatchers.Default) {
                val results = movieRepository.getMovies(category)
                if (results is Result.Success)
                    withContext(Dispatchers.Main) {
                        liveData.value = results.data
                    }
                else Log.e("degea9", "api error ");
            }
        }
    }

}