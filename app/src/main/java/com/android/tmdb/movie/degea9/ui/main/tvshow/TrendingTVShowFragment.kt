package com.android.tmdb.movie.degea9.ui.main.tvshow


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager

import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.ui.main.TmdbViewModelFactory
import com.android.tmdb.movie.degea9.ui.main.tvshow.adapter.TrendingTVShowAdapter
import kotlinx.android.synthetic.main.fragment_trending.*
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class TrendingTVShowFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: TmdbViewModelFactory
    lateinit var tvShowViewModel: TVShowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trending, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_tv_show_trending.layoutManager = GridLayoutManager(this.context, 1)
        tvShowViewModel = ViewModelProviders.of(parentFragment!!, viewModelFactory).get(TVShowViewModel::class.java)
        tvShowViewModel.trendingShows.observe(viewLifecycleOwner, Observer {
            rv_tv_show_trending.adapter = TrendingTVShowAdapter(it)
        })
    }


}
