package com.example.sahabatmakara.base

import android.app.Application
import com.example.sahabatmakara.di.facultyModule
import com.example.sahabatmakara.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
class SahabatMakaraApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@SahabatMakaraApplication)
            modules(facultyModule, viewModelModule)
        }
    }
}