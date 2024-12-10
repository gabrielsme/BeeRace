package com.example.beerace.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.beerace.data.model.Bee
import com.example.beerace.ui.screens.genericerror.GenericErrorScreen
import com.example.beerace.ui.screens.main.MainScreen
import com.example.beerace.ui.screens.race.RaceScreen
import com.example.beerace.ui.screens.webview.WebViewScreen
import com.example.beerace.ui.screens.winner.WinnerScreen
import kotlin.reflect.typeOf

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
                },
                openGenericErrorScreen = {
                    navController.navigate(GenericErrorRoute)
                },
                openWinnerScreen = { bee ->
                    navController.navigate(WinnerRoute(bee))
                }
            )
        }

        composable<WebViewRoute> { backStackEntry ->
            val params = backStackEntry.toRoute<WebViewRoute>()
            WebViewScreen(loadUrl = params.url)
        }

        composable<WinnerRoute>(
            typeMap = mapOf(typeOf<Bee>() to BeeType)
        ) { backStackEntry ->
            val params = backStackEntry.toRoute<WinnerRoute>()
            WinnerScreen(
                bee = params.bee,
                onRestartRaceClick = {
                    navController.navigate(MainRoute) {
                        popUpTo<MainRoute> { inclusive = false }
                    }
                }
            )
        }

        composable<GenericErrorRoute> {
            GenericErrorScreen()
        }

    }
}