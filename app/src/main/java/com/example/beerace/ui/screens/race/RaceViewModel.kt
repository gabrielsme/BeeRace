package com.example.beerace.ui.screens.race

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beerace.data.model.CaptchaErrorResponse
import com.example.beerace.data.repository.RaceRepository
import com.example.beerace.util.extensions.formatTime
import com.google.gson.Gson
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.HttpURLConnection

class RaceViewModel(
    private val raceRepository: RaceRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(RaceUiState())
    val uiState: StateFlow<RaceUiState> = _uiState.asStateFlow()

    fun getRaceDuration() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                beeList = emptyList(),
                genericError = false,
                error403 = null,
                timeRemaining = null,
                timeRemainingDisplay = ""
            )

            raceRepository.getRaceDuration().collect { result ->
                startCountdown(result.timeInSeconds)
            }
        }
    }

    private fun getRaceStatus() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                genericError = false,
                error403 = null
            )

            raceRepository.getRaceStatus()
                .catch { error ->
                    when (error) {
                        is HttpException -> {
                            if (error.code() == HttpURLConnection.HTTP_FORBIDDEN) {
                                val errorBody = error.response()?.errorBody()?.string()
                                val errorResponse =
                                    Gson().fromJson(errorBody, CaptchaErrorResponse::class.java)

                                _uiState.value = _uiState.value.copy(
                                    beeList = emptyList(),
                                    error403 = errorResponse
                                )
                            }
                        }

                        else -> {
                            _uiState.value = _uiState.value.copy(
                                beeList = emptyList(),
                                genericError = true
                            )
                        }
                    }
                }
                .collect { result ->
                    _uiState.value = _uiState.value.copy(
                        beeList = result.beeList
                    )
                }
        }
    }

    private fun startCountdown(totalSeconds: Int) {
        viewModelScope.launch {
            var remainingSeconds = totalSeconds
            while (remainingSeconds >= 0) {
                _uiState.value = _uiState.value.copy(
                    timeRemaining = remainingSeconds,
                    timeRemainingDisplay = remainingSeconds.formatTime()
                )

                getRaceStatus()

                delay(1000)
                remainingSeconds--
            }
        }
    }
}