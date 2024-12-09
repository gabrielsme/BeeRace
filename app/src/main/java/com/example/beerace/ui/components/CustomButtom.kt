package com.example.beerace.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomButtom(
    modifier: Modifier = Modifier,
    action: () -> Unit = {},
    text: String
) {
    Button(
        modifier = modifier.height(56.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(8.dp),
        onClick = {
            action()
        }
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
private fun CustomButtomPreview() {
    CustomButtom(
        text = "Bee Race"
    )
}