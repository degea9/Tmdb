package com.android.tmdb.movie.degea9.di

import dagger.Module
import dagger.Provides
import movietube.tuandang.android.com.movietube.api.interceptor.ApiKeyInterceptor
import movietube.tuandang.android.com.movietube.ui.api.MovieService
import movietube.tuandang.android.com.movietube.util.URLUtils
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule {
    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(ApiKeyInterceptor()).build()
    }

    @Singleton
    @Provides
    fun provideRetrofit( okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(URLUtils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}