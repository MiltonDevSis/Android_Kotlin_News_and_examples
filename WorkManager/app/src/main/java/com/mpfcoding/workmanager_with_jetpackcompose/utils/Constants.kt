package com.mpfcoding.workmanager_with_jetpackcompose.utils

object Constants {

    // api
    const val MAIN_ROOT = "https://pl-coding.com"
    const val COMPLETE_ROOT = "/wp-content/uploads/2022/02/220849-scaled.jpg"

    // Notification channel
    const val ID = "download_channel"
    const val NAME = "file download"

    // Foreground Notification Service
    const val CONTENT_TITLE = "Download in progress"
    const val CONTENT_TEXT = "Downloading..."
}

object WorkerKeys{
    const val ERROR_MSG = "errorMsg"
    const val IMAGE_URI = "imageUri"
    const val FILTER_URI = "filterUri"

    const val CHILD_NAME = "new-image.jpg"
}