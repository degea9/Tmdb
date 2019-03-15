package com.android.tmdb.movie.degea9.ui.top


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.data.api.TmdbService
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.*
import javax.inject.Inject


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : DaggerFragment() {
    @Inject
    lateinit var tmdbService: TmdbService
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
        percentView.percent = 0.75f
        myJob = CoroutineScope(Dispatchers.IO).launch {
            val result = tmdbService.getPlayingMovies().await()
            withContext(Dispatchers.Main) {
                //do something with result
                if (result.isSuccessful) {
                    Log.e("Top", "api success");

                    Log.e("Top", "result size " + result.body()?.results?.size)
                } else Log.e("Top", "api error");

                Log.e("Top", "result " + result.body())
            }

        }
    }


    override fun onDestroy() {
        myJob?.cancel()
        super.onDestroy()
    }

}
