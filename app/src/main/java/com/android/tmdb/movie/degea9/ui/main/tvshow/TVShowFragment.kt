package com.android.tmdb.movie.degea9.ui.main.tvshow


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.ui.main.tvshow.adapter.TVShowViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_tvshow.*


/**
 * A simple [Fragment] subclass.
 *
 */
class TVShowFragment : DaggerFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tvshow, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vp_tv_shows.adapter = TVShowViewPagerAdapter(childFragmentManager)
        activity?.findViewById<TabLayout>(R.id.tab_layout)?.setupWithViewPager(vp_tv_shows)
    }

}
