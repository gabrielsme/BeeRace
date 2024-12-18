package com.example.beerace.ui.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.beerace.R
import com.example.beerace.ui.ScreenPreview
import com.example.beerace.ui.components.CustomButtom

@Composable
fun MainScreen(
    onButtonClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = androidx.compose.ui.Alignment.Center,
    ) {
        CustomButtom(
            action = {
                onButtonClick()
            },
            text = stringResource(R.string.main_button_title)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun MainScreenPreview() {
    ScreenPreview {
        MainScreen()
    }
}