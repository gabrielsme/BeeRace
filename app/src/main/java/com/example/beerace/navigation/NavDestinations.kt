package com.example.beerace.navigation

import com.example.beerace.data.model.Bee
import kotlinx.serialization.Serializable

@Serializable
object MainRoute

@Serializable
object RaceRoute

@Serializable
data class WebViewRoute(val url: String)

@Serializable
data class WinnerRoute(val bee: Bee)

@Serializable
object GenericErrorRoute