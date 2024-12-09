package com.example.beerace.ui.screens.race

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beerace.data.repository.RaceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RaceViewModel(
    private val raceRepository: RaceRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(RaceUiState())
    val uiState: StateFlow<RaceUiState> = _uiState.asStateFlow()

    fun getRaceDuration() {
        viewModelScope.launch {
            raceRepository.getRaceDuration().collect { result ->
                _uiState.value = _uiState.value.copy(
                    timeRemaining = result.timeInSeconds
                )
            }
        }
    }

    fun getRaceStatus() {
        viewModelScope.launch {
            raceRepository.getRaceStatus().collect { result ->
                _uiState.value = _uiState.value.copy(
                    beeList = result.beeList
                )
            }
        }
    }
}