package com.example.beerace.util.extensions

fun Int.formatTime(): String {
    val minutes = (this % 3600) / 60
    val secs = this % 60
    return String.format("%02d:%02d", minutes, secs)
}