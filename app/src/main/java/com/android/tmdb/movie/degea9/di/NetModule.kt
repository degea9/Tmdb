package com.android.tmdb.movie.degea9.di

import com.android.tmdb.movie.degea9.data.api.TmdbService

import com.android.tmdb.movie.degea9.data.api.interceptor.ApiKeyInterceptor
import dagger.Module
import dagger.Provides

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import okhttp3.ConnectionPool
import java.util.concurrent.TimeUnit


@Module
class NetModule {
    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
            .connectTimeout(60000, TimeUnit.MILLISECONDS)
            .retryOnConnectionFailure(true)
            .readTimeout(60000, TimeUnit.MILLISECONDS)
            .connectionPool(ConnectionPool(0, 1, TimeUnit.NANOSECONDS))
        return clientBuilder.addInterceptor(ApiKeyInterceptor()).addInterceptor(loggingInterceptor).build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(TmdbService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

            .addCallAdapterFactory(CoroutineCallAdapterFactory())

            .build()
    }
}