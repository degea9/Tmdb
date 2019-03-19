package com.android.tmdb.movie.degea9.ui.showdetail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ShowViewPagerAdapter(manager:FragmentManager):FragmentPagerAdapter(manager){
    override fun getItem(position: Int): Fragment {
        return when(position){
            0->InfoFragment()
            1->ActorsFragment()
            else->SeasonsFragment()
        }
    }

    override fun getCount(): Int = 3

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "First Tab"
            1 -> "Second Tab"
            else -> {
                return "Third Tab"
            }
        }
    }

}