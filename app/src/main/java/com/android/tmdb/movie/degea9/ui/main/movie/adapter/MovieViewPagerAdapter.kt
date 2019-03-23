package com.android.tmdb.movie.degea9.ui.main.movie.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.data.api.TmdbService.Companion.LATEST_MOVIE
import com.android.tmdb.movie.degea9.data.api.TmdbService.Companion.NOW_PLAYING_MOVIE
import com.android.tmdb.movie.degea9.data.api.TmdbService.Companion.POPULAR_MOVIE
import com.android.tmdb.movie.degea9.data.api.TmdbService.Companion.TOP_RATED_MOVIE
import com.android.tmdb.movie.degea9.data.api.TmdbService.Companion.TRENDING_MOVIE
import com.android.tmdb.movie.degea9.data.api.TmdbService.Companion.UP_COMING_MOVIE
import com.android.tmdb.movie.degea9.ui.main.movie.MovieTabFragment

class MovieViewPagerAdapter(val context: Context, manager: FragmentManager) : FragmentPagerAdapter(manager) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MovieTabFragment.newInstance(NOW_PLAYING_MOVIE)
            1 -> MovieTabFragment.newInstance(TRENDING_MOVIE)
            2 -> MovieTabFragment.newInstance(POPULAR_MOVIE)
            3 -> MovieTabFragment.newInstance(TOP_RATED_MOVIE)
            4 -> MovieTabFragment.newInstance(UP_COMING_MOVIE)
            else -> MovieTabFragment.newInstance(LATEST_MOVIE)
        }
    }

    override fun getCount(): Int = 6

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            NOW_PLAYING_MOVIE -> context.getString(R.string.now_playing)
            TRENDING_MOVIE -> context.getString(R.string.trending)
            POPULAR_MOVIE -> context.getString(R.string.popular)
            TOP_RATED_MOVIE -> context.getString(R.string.top_rated)
            UP_COMING_MOVIE -> context.getString(R.string.upcoming)
            else -> context.getString(R.string.latest)
        }.toUpperCase()
    }

}