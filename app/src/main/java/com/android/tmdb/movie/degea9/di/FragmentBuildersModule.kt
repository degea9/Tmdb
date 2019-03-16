package com.android.tmdb.movie.degea9.di

import com.android.tmdb.movie.degea9.ui.top.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector(modules = [TopModule::class])
    abstract fun contributePopularFragment(): MainFragment

}