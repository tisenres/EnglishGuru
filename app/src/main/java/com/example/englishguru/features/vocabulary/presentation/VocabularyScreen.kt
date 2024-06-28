package com.example.englishguru.features.vocabulary.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.englishguru.features.vocabulary.presentation.components.SectionItem

@Composable
fun VocabularyScreen(navController: NavController) {
    val viewModel: VocabularyViewModel = hiltViewModel()
    val sections by viewModel.sections.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn {
            itemsIndexed(sections) { index, section ->
                SectionItem(section) {
                    navController.navigate("word_screen/${section.startWordPos}/${section.endWordPos}")
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
