@file:Suppress("SameParameterValue")

package com.droid.data.di

import com.droid.data.networkclient.*
import com.droid.data.networkclient.AuthInterceptor
import com.droid.data.networkclient.RetryInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author adityakhullar on 21/06/21.
 */

val networkModule = module {
    single {
        provideAuthInterceptor(BuildConfig.API_KEY)
    }

    single {
        provideRetryInterceptor()
    }
    single {
        provideOkHttpClient(get())
    }

    single {
        provideRetrofit(get(), BuildConfig.BASE_URL)
    }
    single {
        provideRemoteNetworkClient(get())
    }
}

private fun provideRetryInterceptor() = RetryInterceptor()
private fun provideAuthInterceptor(apiKey: String) = AuthInterceptor(apiKey)

private fun provideOkHttpClient(authInterceptor: AuthInterceptor) = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(authInterceptor)
        .build()
} else OkHttpClient
    .Builder()
    .addInterceptor(authInterceptor)
    .build()

private fun provideRetrofit(
    okHttpClient: OkHttpClient,
    baseUrl: String
): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .build()

private fun provideRemoteNetworkClient(retrofit: Retrofit): RemoteNetworkClient {
    return RemoteNetworkClient(retrofit)
}