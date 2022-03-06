package com.mpfcoding.workmanager_with_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mpfcoding.workmanager_with_jetpackcompose.ui.theme.WorkManager_With_jetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkManager_With_jetpackComposeTheme {

            }
        }
    }
}