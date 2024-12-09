package com.example.beerace.ui

import androidx.compose.runtime.Composable
import com.example.beerace.di.koinModules
import com.example.beerace.ui.theme.BeeRaceTheme
import org.koin.compose.KoinApplication

@Composable
fun ScreenPreview(
    screen: @Composable () -> Unit
) {
    KoinApplication(application = {
        modules(koinModules)
    }) {
        BeeRaceTheme(
            darkTheme = false,
            dynamicColor = false
        ) {
            screen()
        }
    }
}