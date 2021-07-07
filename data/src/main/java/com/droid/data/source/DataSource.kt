package com.droid.data.source

import com.droid.domain.Result
import retrofit2.Response

/**
 * @author adityakhullar on 21/06/21.
 */
internal abstract class DataSource {

    abstract suspend fun <T : Any> getResponse(
        request: suspend () -> Response<T>,
        defaultErrorMessage: String
    ): Result<T>
}