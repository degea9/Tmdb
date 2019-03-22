package com.android.tmdb.movie.degea9.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.tmdb.movie.degea9.di.customkey.ViewModelKey
import com.android.tmdb.movie.degea9.ui.showdetail.TvShowDetailViewModel
import com.android.tmdb.movie.degea9.ui.main.TopViewModel
import com.android.tmdb.movie.degea9.ui.main.TmdbViewModelFactory
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
    @IntoMap
    @ViewModelKey(TvShowDetailViewModel::class)
    abstract fun bindTvShowViewModel(topViewModel: TvShowDetailViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: TmdbViewModelFactory): ViewModelProvider.Factory
}