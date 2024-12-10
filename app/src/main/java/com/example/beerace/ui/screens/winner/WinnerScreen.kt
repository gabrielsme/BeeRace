package com.example.beerace.ui.screens.winner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.beerace.R
import com.example.beerace.data.model.Bee
import com.example.beerace.ui.ScreenPreview
import com.example.beerace.ui.components.CustomButtom
import com.example.beerace.util.extensions.toColor

@Composable
fun WinnerScreen(
    bee: Bee,
    onRestartRaceClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = stringResource(R.string.winner_title))

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(bee.color.toColor()),
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = stringResource(R.string.winner_first_place))
        Text(text = bee.name)

        Spacer(modifier = Modifier.height(42.dp))

        CustomButtom(
            action = {
                onRestartRaceClick()
            },
            text = stringResource(R.string.winner_button)
        )

    }
}

@Preview(showSystemUi = true)
@Composable
private fun WinnerScreenPreview() {
    ScreenPreview {
        WinnerScreen(
            bee = Bee(
                name = "BeeGees",
                color = "#AAFFCC"
            )
        )
    }
}