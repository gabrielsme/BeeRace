package com.example.beerace.util.extensions

import androidx.compose.ui.graphics.Color

fun String.toColor(): Color {
    return try {
        Color(android.graphics.Color.parseColor(this))
    } catch (e: IllegalArgumentException) {
        Color.Black
    }
}