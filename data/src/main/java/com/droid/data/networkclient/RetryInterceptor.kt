package com.droid.data.networkclient

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author adityakhullar on 21/06/21.
 */

private const val INIT_TRYOUT = 1
private const val MAX_TRYOUTS = 3

internal class RetryInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        var response = chain.proceed(request)
        var tryOuts = INIT_TRYOUT

        while (!response.isSuccessful && tryOuts < MAX_TRYOUTS) {
            Log.d(
                this@RetryInterceptor.javaClass.simpleName,
                "intercept: timeout/connection failure, " +
                        "performing automatic retry ${(tryOuts + 1)}"
            )
            tryOuts++
            response = chain.proceed(request)
        }
        return response
    }
}