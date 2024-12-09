package com.example.beerace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.beerace.navigation.AppNavigation
import com.example.beerace.ui.theme.BeeRaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BeeRaceTheme(
                darkTheme = false,
                dynamicColor = false
            ) {
                AppNavigation()
            }
        }
    }
}
