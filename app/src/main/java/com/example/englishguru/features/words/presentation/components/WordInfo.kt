package com.example.englishguru.features.words.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun WordInfo(
    word: String,
    definition: String,
    examples: String,
    synonyms: String,
    partOfSpeech: String,
    similarTo: String,
    derivation: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        InfoCard(title = "Word", content = word, color = MaterialTheme.colorScheme.primary)
        InfoCard(title = "Definition", content = definition, color = Color(0xFF3AB6BA))
        InfoCard(title = "Examples", content = examples, color = Color(0xFF0B16E5))
        InfoCard(title = "Synonyms", content = synonyms, color = Color(0xFF59C531))
        InfoCard(title = "Part of Speech", content = partOfSpeech, color = Color(0xFFDEE50B))
        InfoCard(title = "Similar To", content = similarTo, color = Color(0xFFDC670F))
        InfoCard(title = "Derivation", content = derivation, color = Color(0xFF0B8EE5))
    }
}

@Composable
fun InfoCard(title: String, content: String, color: Color) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodySmall,
                color = color,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = content,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
