package com.example.beerace.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.beerace.ui.screens.main.MainScreen
import com.example.beerace.ui.screens.race.RaceScreen
import com.example.beerace.ui.screens.webview.WebViewScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MainRoute
    ) {

        composable<MainRoute> {
            MainScreen(
                onButtonClick = {
                    navController.navigate(RaceRoute)
                }
            )
        }

        composable<RaceRoute> {
            RaceScreen(
                openWebView = { url ->
                    navController.navigate(WebViewRoute(url))
                }
            )
        }

        composable<WebViewRoute> { backStackEntry ->
            val params = backStackEntry.toRoute<WebViewRoute>()
            WebViewScreen(loadUrl = params.url)
        }

    }
}