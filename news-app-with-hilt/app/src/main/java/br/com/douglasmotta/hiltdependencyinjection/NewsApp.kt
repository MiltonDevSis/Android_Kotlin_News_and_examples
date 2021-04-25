package br.com.douglasmotta.hiltdependencyinjection

import android.app.Application
import com.androidnetworking.AndroidNetworking
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsApp : Application() {

    override fun onCreate() {
        super.onCreate()

        AndroidNetworking.initialize(applicationContext)
    }
}