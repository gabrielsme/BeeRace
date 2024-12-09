package com.example.beerace

import android.app.Application
import com.example.beerace.di.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class BeeRaceApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@BeeRaceApplication)
            modules(koinModules)
        }
    }
}