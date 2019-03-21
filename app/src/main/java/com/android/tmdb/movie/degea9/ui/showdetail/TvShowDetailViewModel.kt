package com.android.tmdb.movie.degea9.ui.showdetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.tmdb.movie.degea9.data.api.Result
import com.android.tmdb.movie.degea9.data.database.entity.Credit
import com.android.tmdb.movie.degea9.data.database.entity.TVShow
import com.android.tmdb.movie.degea9.data.database.entity.TvShowDetail
import com.android.tmdb.movie.degea9.data.shows.ShowRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TvShowDetailViewModel @Inject constructor(
    private val showRepository: ShowRepository
) : ViewModel() {

    private val _showLoading = MutableLiveData<Boolean>()
    val showLoading: LiveData<Boolean>
        get() = _showLoading
    private val _tvShowDetail = MutableLiveData<TvShowDetail>()
    val tvShowDetail: LiveData<TvShowDetail>
        get() = _tvShowDetail

    private val _credit = MutableLiveData<Credit>()
    val credit: LiveData<Credit>
        get() = _credit

    init {


    }


    fun loadTvShow(id: Int) {
        viewModelScope.launch(Dispatchers.Default) {
            _showLoading.postValue(true)
            val results = showRepository.getShowDetail(id)
            when(results){
                is Result.Success -> withContext(Dispatchers.Main) {
                    _showLoading.value = false
                    _tvShowDetail.value = results.data
                }

                is Result.Error -> {
                    _showLoading.postValue(false)
                    Log.e("degea9", "TvShowDetailViewModel loadTvShow api error ");
                }
            }
        }
    }

    fun getCredit(id: Int) {
        viewModelScope.launch(Dispatchers.Default) {
            val results = showRepository.getCredit(id)
            if (results is Result.Success)
                withContext(Dispatchers.Main) {
                    _credit.value = results.data
                }
            else Log.e("degea9", "api error ");
        }
    }

}