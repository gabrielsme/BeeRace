package com.example.beerace.ui.screens.race

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.beerace.R
import com.example.beerace.ui.ScreenPreview
import org.koin.androidx.compose.koinViewModel

@Composable
fun RaceScreen(
    viewModel: RaceViewModel = koinViewModel()
) {
    Column {
        Text(text = stringResource(R.string.race_title))
    }

    LaunchedEffect(Unit) {
        viewModel.getRaceDuration()
    }
}

@Preview(showSystemUi = true)
@Composable
private fun RaceScreenPreview() {
    ScreenPreview {
        RaceScreen()
    }
}