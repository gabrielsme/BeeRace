package com.example.beerace.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.beerace.ui.screens.main.MainScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MainRoute
    ) {

        composable<MainRoute> {
            MainScreen()
        }

    }
}