package com.android.tmdb.movie.degea9.ui.main.tvshow.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.android.tmdb.movie.degea9.ui.main.tvshow.TrendingTVShowFragment

class TVShowViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> TrendingTVShowFragment()
            1 -> TrendingTVShowFragment()
            else -> TrendingTVShowFragment()
        }
    }

    override fun getCount(): Int = 3

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "TRENDING"
            1 -> "ANTICIPATED"
            else -> {
                return "AIRING TODAY"
            }
        }
    }

}