package com.example.myfirstkmmapp.android

import android.app.Application
import com.example.myfirstkmmapp.android.di.databaseMode
import com.example.myfirstkmmapp.android.di.viewModelsModule
import com.example.myfirstkmmapp.di.sharedModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyFirstKMMApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedModules + viewModelsModule + databaseMode

        startKoin {
            androidContext(this@MyFirstKMMApplication)
            modules(modules)
        }
    }
}