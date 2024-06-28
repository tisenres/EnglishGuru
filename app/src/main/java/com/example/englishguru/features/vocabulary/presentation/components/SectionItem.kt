package com.example.englishguru.features.vocabulary.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.englishguru.features.vocabulary.domain.model.Section
import com.example.englishguru.R

@Composable
fun SectionItem(section: Section, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = getSectionImage(section)),
                contentDescription = null,
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = section.name, style = MaterialTheme.typography.bodySmall)
                Text(text = section.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

fun getSectionImage(section: Section): Int {
    return when (section) {
        is Section.A1 -> R.drawable.imagea1
        is Section.A2 -> R.drawable.imagea2
        is Section.B1 -> R.drawable.imageb1
        is Section.B2 -> R.drawable.imageb2
        is Section.C1 -> R.drawable.imagec1
    }
}
