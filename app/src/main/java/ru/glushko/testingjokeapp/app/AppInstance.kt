package ru.glushko.testingjokeapp.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.glushko.testingjokeapp.di.dataModule
import ru.glushko.testingjokeapp.di.domainModule
import ru.glushko.testingjokeapp.di.presentationModule

class AppInstance  : Application() {
    companion object {
        var instance = AppInstance()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin {
            androidContext(this@AppInstance)
            modules(listOf(presentationModule, domainModule, dataModule))
        }
    }
}