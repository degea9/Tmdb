package com.android.tmdb.movie.degea9.ui.moviedetail.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.android.tmdb.movie.degea9.R
import com.android.tmdb.movie.degea9.ui.moviedetail.MovieCastFragment
import com.android.tmdb.movie.degea9.ui.moviedetail.MovieInfoFragment
import com.android.tmdb.movie.degea9.ui.moviedetail.MovieReviewFragment

class MovieDetailViewPagerAdapter(val context: Context, manager: FragmentManager) : FragmentPagerAdapter(manager) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MovieInfoFragment()
            1 -> MovieCastFragment()
            else ->MovieReviewFragment()
        }
    }

    override fun getCount(): Int = 3

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> context.getString(R.string.info_tab)
            1 -> context.getString(R.string.cast_tab)
            2 -> context.getString(R.string.review_tab)
            else -> context.getString(R.string.review_tab)
        }
    }

}