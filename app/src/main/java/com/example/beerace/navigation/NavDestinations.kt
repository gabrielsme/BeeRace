package com.example.beerace.navigation

import kotlinx.serialization.Serializable

@Serializable
object MainRoute

@Serializable
object RaceRoute

@Serializable
data class WebViewRoute(val url: String)