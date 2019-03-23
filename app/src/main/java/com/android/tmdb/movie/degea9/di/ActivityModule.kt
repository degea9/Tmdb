package com.android.tmdb.movie.degea9.di

import com.android.tmdb.movie.degea9.ui.main.MainActivity
import com.android.tmdb.movie.degea9.ui.moviedetail.MovieDetailActivity
import com.android.tmdb.movie.degea9.ui.showdetail.ShowDetailActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMovieDetailActivity(): MovieDetailActivity

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeShowDetailActivity(): ShowDetailActivity

}