package com.muhammed.android_compose_navigation_task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.muhammed.android_compose_navigation_task.composables.WelcomeScreen
import com.muhammed.android_compose_navigation_task.ui.theme.AndroidComposeNavigationTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidComposeNavigationTaskTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ParcelNavHost(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}