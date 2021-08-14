package com.droid.data.datasource

import com.droid.domain.Result
import retrofit2.Response

/**
 * @author adityakhullar on 09/07/21.
 */
internal interface RemoteDataSource : DataSource {

    suspend fun <T : Any> getResponse(
        request: suspend () -> Response<T>,
        defaultErrorMessage: String
    ): Result<T> {
        return try {
            val result = request.invoke()
            if (result.isSuccessful) {
                return Result.Success(result.body())
            } else {
                Result.Failure(defaultErrorMessage)
            }
        } catch (e: Throwable) {
            Result.Failure("Unknown Error")
        }
    }
}