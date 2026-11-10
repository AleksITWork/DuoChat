package com.example.duochat

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import com.example.duochat.navigation.DuoChatNavHost
import com.example.duochat.ui.theme.DuoChatTheme

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DuoChatTheme {
                DuoChatNavHost()
            }
        }
    }
}