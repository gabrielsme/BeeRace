package com.example.beerace.di

import com.example.beerace.ui.screens.race.RaceViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { RaceViewModel() }
}

val koinModules = listOf(
    viewModelModule,
)