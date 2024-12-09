package com.example.beerace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.beerace.navigation.AppNavigation
import com.example.beerace.ui.theme.BeeRaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
