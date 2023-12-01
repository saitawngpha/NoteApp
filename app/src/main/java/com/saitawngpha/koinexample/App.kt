package com.saitawngpha.koinexample

import android.app.Application
import com.saitawngpha.koinexample.di.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * @Author: ၸၢႆးတွင်ႉၾႃႉ
 * @Date: 30/11/2023.
 */
class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(databaseModule)
        }
    }
}