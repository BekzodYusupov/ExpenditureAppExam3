package uz.gita.examgroup3.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    companion object {
        var instance: App? = null
        fun getInstanceApp() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}