package com.example.beerace.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.beerace.R
import com.example.beerace.data.model.Bee
import com.example.beerace.util.extensions.toColor

@Composable
fun ListBeeItem(
    item: Bee,
    position: Int = 0
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(item.color.toColor()),
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(text = position.toString(), fontWeight = FontWeight.Bold)
            Text(text = item.name, color = Color.Gray)
        }

        val medalIcon = when (position) {
            1 -> R.drawable.medaille_1
            2 -> R.drawable.medaille_2
            3 -> R.drawable.medaille_3
            else -> null
        }
        if (medalIcon != null) {
            Icon(
                painter = painterResource(id = medalIcon),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview
@Composable
private fun ListBeeItemPreview() {
    ListBeeItem(
        Bee(
            name = "Bee",
            color = "#FF0000",
        )
    )
}