package com.android.tmdb.movie.degea9.di

import com.android.tmdb.movie.degea9.data.api.TmdbService
import com.android.tmdb.movie.degea9.data.shows.ShowRemoteDataSource
import com.android.tmdb.movie.degea9.data.shows.ShowRepository
import com.android.tmdb.movie.degea9.ui.top.TopViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TopModule {

    @Provides
    fun provideShowRemoteDataSource(service: TmdbService): ShowRemoteDataSource {
        return ShowRemoteDataSource(service)
    }

    @Provides
    fun provideShowRepository(remoteDataSource: ShowRemoteDataSource): ShowRepository {
        return ShowRepository(remoteDataSource)
    }

    @Provides
    fun provideTopViewModelFactory(showRepository: ShowRepository): TopViewModelFactory {
        return TopViewModelFactory(showRepository)
    }
}