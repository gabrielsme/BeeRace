package com.example.beerace.ui.screens.race

import com.example.beerace.data.model.Bee
import com.example.beerace.data.model.CaptchaErrorResponse

data class RaceUiState(
    val timeRemaining: Int? = null,
    val timeRemainingDisplay: String = "",
    val beeList: List<Bee> = emptyList(),
    val error403: CaptchaErrorResponse? = null,
    val genericError: Boolean = false
)