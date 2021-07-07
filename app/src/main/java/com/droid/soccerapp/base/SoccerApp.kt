package com.droid.soccerapp.base

import android.app.Application
import com.droid.data.di.dataSourceModule
import com.droid.data.di.mapperModule
import com.droid.data.di.repositoryModule
import com.droid.data.di.networkModule
import com.droid.soccerapp.di.useCasesModule
import com.droid.soccerapp.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


/**
 * @author adityakhullar on 21/06/21.
 */

class SoccerApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@SoccerApp)
            modules(
                listOf(
                    viewModelsModule,
                    mapperModule,
                    dataSourceModule,
                    repositoryModule,
                    useCasesModule,
                    networkModule
                )
            )

        }
    }
}