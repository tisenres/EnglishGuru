package com.example.englishguru.features.words.presentation.components

import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun OptionButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Button(
            onClick = { /* Again logic */ },
            modifier = Modifier
                .weight(1f)
                .height(100.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFE52EE1))
        ) {
            Text(text = "Again", color = Color.White)
        }
        Button(
            onClick = { /* Hard logic */ },
            modifier = Modifier
                .weight(1f)
                .height(100.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFDC670F))
        ) {
            Text(text = "Hard", color = Color.White)
        }
        Button(
            onClick = { /* Good logic */ },
            modifier = Modifier
                .weight(1f)
                .height(100.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF3AB6BA))
        ) {
            Text(text = "Good", color = Color.White)
        }
        Button(
            onClick = { /* Easy logic */ },
            modifier = Modifier
                .weight(1f)
                .height(100.dp),
        ) {
            Text(text = "Easy", color = Color.White)
        }
    }
}
