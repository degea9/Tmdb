package com.android.tmdb.movie.degea9.ui.main.movie.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.android.tmdb.movie.degea9.ui.main.movie.NowPlayingFragment
import com.android.tmdb.movie.degea9.ui.showdetail.ActorsFragment
import com.android.tmdb.movie.degea9.ui.showdetail.InfoFragment
import com.android.tmdb.movie.degea9.ui.showdetail.SeasonsFragment

class MovieViewPagerAdapter(manager: FragmentManager): FragmentPagerAdapter(manager){
    override fun getItem(position: Int): Fragment {
        return when(position){
            0-> NowPlayingFragment()
            1-> NowPlayingFragment()
            else-> NowPlayingFragment()
        }
    }

    override fun getCount(): Int = 3

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "NOW PLAYING"
            1 -> "TOP BOX OFFICE"
            else -> {
                return "SEASONS"
            }
        }
    }

}