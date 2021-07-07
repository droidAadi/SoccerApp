package com.droid.data.networkclient

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author adityakhullar on 21/06/21.
 */

internal class RemoteNetworkClient(private val retrofit: Retrofit) {

    fun <S> createService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }
}