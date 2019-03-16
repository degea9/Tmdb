package com.android.tmdb.movie.degea9.ui.top


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.tmdb.movie.degea9.R
import dagger.android.support.DaggerFragment
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
    lateinit var topViewModelFactory:TopViewModelFactory

    lateinit var topViewModel: TopViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        topViewModel = ViewModelProviders.of(this,topViewModelFactory).get(TopViewModel::class.java)
        topViewModel.broadcastingShows.observe(viewLifecycleOwner, Observer {
            Log.e("degea9", "tvshow on the air size " + it.size)
        })
    }


}
