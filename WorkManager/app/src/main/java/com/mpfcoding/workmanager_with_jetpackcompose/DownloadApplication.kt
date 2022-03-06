package com.mpfcoding.workmanager_with_jetpackcompose

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.mpfcoding.workmanager_with_jetpackcompose.utils.Constants

class DownloadApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                Constants.ID,
                Constants.NAME,
                NotificationManager.IMPORTANCE_HIGH
            )

            val notificationManager = getSystemService(NotificationManager::class.java).apply {
                createNotificationChannel(channel)
            }
        }
    }
}