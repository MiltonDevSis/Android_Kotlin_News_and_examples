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

    // Any
    const val DOWNLOAD = "download"
    const val START_DOWNLOAD = "Start download"
}

object WorkerKeys {
    const val ERROR_MSG = "errorMsg"
    const val IMAGE_URI = "imageUri"
    const val FILTER_URI = "filterUri"

    const val START_PREFIX = "5"

    const val NETWORK_ERROR = "Network error"
    const val UNKNOWN_ERROR = "Unknown error"

    const val CHILD_NAME_DOWNLOAD = "image.jpg"
    const val CHILD_NAME_COLOR_FILTER = "new-image.jpg"
}

object WorkInfoState {
    const val DOWNLOAD_RUNNING = "Downloading..."
    const val DOWNLOAD_SUCCEEDED = "Download succeeded"
    const val DOWNLOAD_FAILED = "Download failed"
    const val DOWNLOAD_CANCELLED = "Download cancelled"
    const val DOWNLOAD_ENQUEUED = "Download enqueued"
    const val DOWNLOAD_BLOCKED = "Download blocked"

    const val FILTER_RUNNING = "Applying filter..."
    const val FILTER_SUCCEEDED = "Filter succeeded"
    const val FILTER_FAILED = "Filter failed"
    const val FILTER_CANCELLED = "Filter cancelled"
    const val FILTER_ENQUEUED = "Filter enqueued"
    const val FILTER_BLOCKED = "Filter blocked"
}