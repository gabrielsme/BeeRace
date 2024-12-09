package com.example.beerace.ui.screens.race

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beerace.data.repository.RaceRepository
import kotlinx.coroutines.launch

class RaceViewModel(
    private val raceRepository: RaceRepository
) : ViewModel() {

    fun getRaceDuration() {
        viewModelScope.launch {
            raceRepository.getRaceDuration().collect {
                Log.d("GABRIEL", it.toString())
            }
        }
    }
}