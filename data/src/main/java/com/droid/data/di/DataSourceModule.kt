package com.droid.data.di

import com.droid.data.networkclient.RemoteNetworkClient
import com.droid.data.source.DataSource
import com.droid.data.source.CompetitionRemoteDataSource
import org.koin.dsl.module

/**
 * @author adityakhullar on 21/06/21.
 */

val dataSourceModule = module {
    factory<DataSource> {
        provideDataSource(get())
    }
}

private fun provideDataSource(remoteNetworkClient: RemoteNetworkClient): CompetitionRemoteDataSource {
    return CompetitionRemoteDataSource(remoteNetworkClient)
}

