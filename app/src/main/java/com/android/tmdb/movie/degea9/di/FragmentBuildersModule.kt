package com.android.tmdb.movie.degea9.di

import com.android.tmdb.movie.degea9.ui.main.movie.MovieFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector(modules = [ChildFragmentBuilderModule::class])
    abstract fun contributeMovieFragment(): MovieFragment

}