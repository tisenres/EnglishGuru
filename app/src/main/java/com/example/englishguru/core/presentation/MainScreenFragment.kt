package com.example.englishguru.core.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.navigate("vocabulary_screen") }) {
            Text(text = "Vocabulary")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("translator_screen") }) {
            Text(text = "Translator")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("chatbot_screen") }) {
            Text(text = "ChatBot")
        }
    }
}
