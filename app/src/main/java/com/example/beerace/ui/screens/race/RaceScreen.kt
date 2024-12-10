package com.example.beerace.ui.screens.race

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beerace.R
import com.example.beerace.data.model.Bee
import com.example.beerace.ui.ScreenPreview
import com.example.beerace.ui.components.ListBeeItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun RaceScreen(
    viewModel: RaceViewModel = koinViewModel(),
    openWebView: (String) -> Unit = {},
    openGenericErrorScreen: () -> Unit = {},
    openWinnerScreen: (Bee) -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsState()

    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(R.string.race_title), color = Color.White)
            Text(text = uiState.timeRemainingDisplay, color = Color.White, fontSize = 30.sp)
        }

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(uiState.beeList) { index, bee ->
                ListBeeItem(bee, index + 1)
                HorizontalDivider(color = Color.Gray, thickness = 1.dp)
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.getRaceDuration()
    }
    LaunchedEffect(uiState.error403) {
        if (uiState.error403 != null) {
            openWebView(uiState.error403?.captchaUrl ?: "")
        }
    }
    LaunchedEffect(uiState.genericError) {
        if (uiState.genericError) {
            openGenericErrorScreen()
        }
    }
    LaunchedEffect(uiState.timeRemaining) {
        if (uiState.timeRemaining == 0 && uiState.beeList.isNotEmpty()) {
            openWinnerScreen(uiState.beeList.first())
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun RaceScreenPreview() {
    ScreenPreview {
        RaceScreen()
    }
}