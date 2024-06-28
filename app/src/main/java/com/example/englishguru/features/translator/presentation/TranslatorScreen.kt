package com.example.englishguru.features.translator.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.englishguru.R

@Composable
fun TranslatorScreen(navController: NavController) {
    var sourceText by remember { mutableStateOf("") }
    val targetText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Spinner()
            IconButton(onClick = { /* Swap languages logic */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_compare_arrows_24),
                    contentDescription = "Swap languages"
                )
            }
            Spinner()
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(MaterialTheme.colorScheme.surface)
                .padding(10.dp)
        ) {
            Text(
                text = "Source lang",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            BasicTextField(
                value = sourceText,
                onValueChange = { sourceText = it },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            )
            Button(
                onClick = { /* Translate logic */ },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Translate")
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(MaterialTheme.colorScheme.surface)
                .padding(10.dp)
        ) {
            Text(
                text = "Target lang",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = targetText,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            )
        }
    }
}

@Composable
fun Spinner() {
    // Implement your Spinner composable
}