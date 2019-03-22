package com.android.tmdb.movie.degea9.util

import com.android.tmdb.movie.degea9.data.api.DataResponse
import com.android.tmdb.movie.degea9.data.api.Result
import kotlinx.coroutines.Deferred
import retrofit2.Response
import java.io.IOException

fun <RESPONSE: DataResponse<T>,T : Any> Response<RESPONSE>.getResult(): Result<T> {
        if (isSuccessful) {
            val body = body()
            body?.run {
                return Result.Success(body.retrieveData())
            }
        }
        return Result.Error(
            IOException("Error ${code()} ${message()}")
        )
}

/**
 * Wrap a suspending API [call] in try/catch. In case an exception is thrown, a [Result.Error] is
 * created based on the [errorMessage].
 */
suspend fun <RESPONSE : DataResponse<T>,T:Any> safeApiCall(deferred: Deferred<Response<RESPONSE>>, errorMessage: String): Result<T> {
    return try {
        deferred.await().getResult()
    } catch (e: Exception) {
        // An exception was thrown when calling the API so we're converting this to an IOException
        Result.Error(IOException(errorMessage, e))
    }
}


