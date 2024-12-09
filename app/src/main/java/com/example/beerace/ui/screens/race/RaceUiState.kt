package com.example.beerace.ui.screens.race

import com.example.beerace.data.model.Bee

data class RaceUiState(
    val timeRemaining: Int = 0,
    val timeRemainingDisplay: String = "00:00",
    val beeList: List<Bee> = emptyList()
)