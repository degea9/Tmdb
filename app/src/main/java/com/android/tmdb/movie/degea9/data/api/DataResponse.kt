package com.android.tmdb.movie.degea9.data.api

interface DataResponse<T> {
    fun retrieveData(): T
}