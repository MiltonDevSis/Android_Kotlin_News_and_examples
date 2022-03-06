package com.mpfcoding.workmanager_with_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.work.*
import coil.compose.rememberImagePainter
import com.mpfcoding.workmanager_with_jetpackcompose.ui.theme.WorkManager_With_jetpackComposeTheme
import com.mpfcoding.workmanager_with_jetpackcompose.utils.Constants
import com.mpfcoding.workmanager_with_jetpackcompose.utils.WorkInfoState
import com.mpfcoding.workmanager_with_jetpackcompose.utils.WorkerKeys

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val downloadRequest = OneTimeWorkRequestBuilder<DownloadWorker>()
            .setConstraints(
                Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()
            )
            .build()
        val colorFilterRequest = OneTimeWorkRequestBuilder<ColorFilterWorker>().build()
        val workManager = WorkManager.getInstance(applicationContext)

        setContent {
            WorkManager_With_jetpackComposeTheme {
                val workInfos = workManager
                    .getWorkInfosForUniqueWorkLiveData(Constants.DOWNLOAD)
                    .observeAsState()
                    .value
                val downloadInfo = remember(key1 = workInfos) {
                    workInfos?.find { it.id == downloadRequest.id }
                }
                val filterInfo = remember(key1 = workInfos) {
                    workInfos?.find { it.id == colorFilterRequest.id }
                }
                val imageUri by derivedStateOf {
                    val downloadUri = downloadInfo?.outputData?.getString(WorkerKeys.IMAGE_URI)?.toUri()
                    val filterUri = filterInfo?.outputData?.getString(WorkerKeys.FILTER_URI)?.toUri()
                    filterUri ?: downloadUri
                }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    imageUri?.let { uri ->
                        Image(
                            painter = rememberImagePainter(
                                data = uri
                            ),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                    Button(
                        onClick = {
                            workManager
                                .beginUniqueWork(
                                    Constants.DOWNLOAD,
                                    ExistingWorkPolicy.KEEP,
                                    downloadRequest
                                )
                                .then(colorFilterRequest)
                                .enqueue()
                        },
                        enabled = downloadInfo?.state != WorkInfo.State.RUNNING
                    ) {
                        Text(text = Constants.START_DOWNLOAD)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    when(downloadInfo?.state) {
                        WorkInfo.State.RUNNING -> Text(WorkInfoState.DOWNLOAD_RUNNING)
                        WorkInfo.State.SUCCEEDED -> Text(WorkInfoState.DOWNLOAD_SUCCEEDED)
                        WorkInfo.State.FAILED -> Text(WorkInfoState.DOWNLOAD_FAILED)
                        WorkInfo.State.CANCELLED -> Text(WorkInfoState.DOWNLOAD_CANCELLED)
                        WorkInfo.State.ENQUEUED -> Text(WorkInfoState.DOWNLOAD_ENQUEUED)
                        WorkInfo.State.BLOCKED -> Text(WorkInfoState.DOWNLOAD_BLOCKED)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    when(filterInfo?.state) {
                        WorkInfo.State.RUNNING -> Text(WorkInfoState.FILTER_RUNNING)
                        WorkInfo.State.SUCCEEDED -> Text(WorkInfoState.FILTER_SUCCEEDED)
                        WorkInfo.State.FAILED -> Text(WorkInfoState.FILTER_FAILED)
                        WorkInfo.State.CANCELLED -> Text(WorkInfoState.FILTER_CANCELLED)
                        WorkInfo.State.ENQUEUED -> Text(WorkInfoState.FILTER_ENQUEUED)
                        WorkInfo.State.BLOCKED -> Text(WorkInfoState.FILTER_BLOCKED)
                    }
                }
            }
        }
    }
}