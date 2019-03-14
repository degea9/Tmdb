package com.android.tmdb.movie.degea9.ui.top


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.tmdb.movie.degea9.R

import com.android.tmdb.movie.degea9.data.api.TmdbService
import com.android.tmdb.movie.degea9.data.api.interceptor.ApiKeyInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.*

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : Fragment() {
    private var myJob: Job? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpClient = OkHttpClient.Builder().addInterceptor(ApiKeyInterceptor()).addInterceptor(interceptor).build()
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(TmdbService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        val tmdbService = retrofit.create(TmdbService::class.java)
        myJob = CoroutineScope(Dispatchers.IO).launch {
            val result = tmdbService.getPlayingMovies().await()
            withContext(Dispatchers.Main) {
                //do something with result
                if(result.isSuccessful) {
                    Log.e("Top", "api success");
                    Log.e("Top","result size "+result.body()?.results?.size)
                }
                else Log.e("Top","api error");
            }
        }
    }

    override fun onDestroy() {
        myJob?.cancel()
        super.onDestroy()
    }

}
