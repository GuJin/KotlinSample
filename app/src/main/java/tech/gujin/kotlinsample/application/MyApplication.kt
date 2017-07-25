package tech.gujin.kotlinsample.application

import android.app.Application
import android.content.Context

class MyApplication : Application() {
    companion object {
        lateinit var sContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        sContext = applicationContext
    }
}