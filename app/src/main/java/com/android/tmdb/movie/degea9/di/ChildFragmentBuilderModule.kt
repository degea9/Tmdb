package com.android.tmdb.movie.degea9.di

import com.android.tmdb.movie.degea9.ui.main.movie.MovieTabFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ChildFragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeNowPlayingFragment(): MovieTabFragment

}