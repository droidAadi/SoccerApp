package com.droid.data.di

import com.droid.data.networkclient.RemoteNetworkClient
import com.droid.data.datasource.CompetitionRemoteDataSource
import com.droid.data.datasource.CompetitionRemoteDataSourceImpl
import org.koin.dsl.module

/**
 * @author adityakhullar on 21/06/21.
 */

val dataSourceModule = module {
    factory {
        provideCompetitionRemoteDataSource(get())
    }
}

private fun provideCompetitionRemoteDataSource(remoteNetworkClient: RemoteNetworkClient): CompetitionRemoteDataSource {
    return CompetitionRemoteDataSourceImpl(remoteNetworkClient)
}

