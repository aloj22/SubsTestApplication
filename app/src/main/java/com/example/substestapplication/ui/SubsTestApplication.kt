package com.example.substestapplication.ui

import android.app.Application
import com.example.substestapplication.di.KoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SubsTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SubsTestApplication)
            modules(listOf(KoinModules.VIEW_MODEL_MODULE, KoinModules.USE_CASE_MODULE, KoinModules.DATA_MODULE,
                KoinModules.UTIL_MODULE))
        }
    }

}