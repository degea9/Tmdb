package com.android.tmdb.movie.degea9.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.tmdb.movie.degea9.di.customkey.ViewModelKey
import com.android.tmdb.movie.degea9.ui.top.TopViewModel
import com.android.tmdb.movie.degea9.ui.top.TmdbViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(TopViewModel::class)
    abstract fun bindTopViewModel(topViewModel: TopViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: TmdbViewModelFactory): ViewModelProvider.Factory
}