package com.android.tmdb.movie.degea9.ui.showdetail.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.android.tmdb.movie.degea9.ui.showdetail.ActorsFragment
import com.android.tmdb.movie.degea9.ui.showdetail.InfoFragment
import com.android.tmdb.movie.degea9.ui.showdetail.SeasonsFragment

class ShowViewPagerAdapter(manager:FragmentManager):FragmentPagerAdapter(manager){
    override fun getItem(position: Int): Fragment {
        return when(position){
            0-> InfoFragment()
            1-> ActorsFragment()
            else-> SeasonsFragment()
        }
    }

    override fun getCount(): Int = 3

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "INFO"
            1 -> "ACTORS"
            else -> {
                return "SEASONS"
            }
        }
    }

}