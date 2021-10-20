package com.levelup.jokester

import android.app.Application
import com.levelup.jokester.di.appModule
import com.levelup.jokester.di.localModule
import com.levelup.jokester.di.remoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Jokester : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Jokester)
            modules(listOf(remoteModule, localModule, appModule))
        }

       
    }
}