package com.android.tmdb.movie.degea9.util

import com.android.tmdb.movie.degea9.data.api.Result
import retrofit2.Response
import java.io.IOException

fun <T : Any> Response<T>.getResult(): Result<T> {
    return try {
        if (isSuccessful) {
            val body = body()
            body?.run {
                return Result.Success(body)
            }
        }
        return Result.Error(
            IOException("Error ${code()} ${message()}")
        )
    } catch (e: Exception) {
        Result.Error(IOException("Error ", e))
    }
}