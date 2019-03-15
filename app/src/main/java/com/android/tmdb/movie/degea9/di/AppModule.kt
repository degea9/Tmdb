package com.android.tmdb.movie.degea9.di

import com.android.tmdb.movie.degea9.data.api.TmdbService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideMovieService(retrofit: Retrofit): TmdbService {
        return retrofit.create(TmdbService::class.java)
    }
}