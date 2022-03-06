package com.mpfcoding.workmanager_with_jetpackcompose

import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.net.toUri
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.mpfcoding.workmanager_with_jetpackcompose.network.FileApi
import com.mpfcoding.workmanager_with_jetpackcompose.utils.Constants
import com.mpfcoding.workmanager_with_jetpackcompose.utils.WorkerKeys
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import kotlin.random.Random

@Suppress("BlockingMethodInNonBlockingContext")
class DownloadWorker(
    private val context: Context,
    private val workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        startForegroundService()
        delay(5000L)
        val response = FileApi.instance.downloadImage()
        response.body()?.let { body ->
            return withContext(Dispatchers.IO) {
                val file = File(context.cacheDir, WorkerKeys.CHILD_NAME_DOWNLOAD)
                val outputStream = FileOutputStream(file)
                outputStream.use { stream ->
                    try {
                        stream.write(body.bytes())
                    } catch(e: IOException) {
                        return@withContext Result.failure(
                            workDataOf(
                                WorkerKeys.ERROR_MSG to e.localizedMessage
                            )
                        )
                    }
                }
                Result.success(
                    workDataOf(
                        WorkerKeys.IMAGE_URI to file.toUri().toString()
                    )
                )
            }
        }
        if(!response.isSuccessful) {
            if(response.code().toString().startsWith(WorkerKeys.START_PREFIX)) {
                return Result.retry()
            }
            return Result.failure(
                workDataOf(
                    WorkerKeys.ERROR_MSG to WorkerKeys.NETWORK_ERROR
                )
            )
        }
        return Result.failure(
            workDataOf(WorkerKeys.ERROR_MSG to WorkerKeys.UNKNOWN_ERROR)
        )
    }

    private suspend fun startForegroundService() {
        setForeground(
            ForegroundInfo(
                Random.nextInt(),
                NotificationCompat.Builder(context, Constants.ID)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle(Constants.CONTENT_TITLE)
                    .setContentText(Constants.CONTENT_TEXT)
                    .build()
            )
        )
    }
}