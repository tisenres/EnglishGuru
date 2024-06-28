package com.example.englishguru.core.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.englishguru.R

@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.braingwihoutbg),
            contentDescription = stringResource(id = R.string.brain_icon),
            modifier = Modifier
                .size(200.dp)
                .padding(top = 50.dp)
        )
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(top = 30.dp, bottom = 10.dp)
        )
        Text(
            text = stringResource(id = R.string.logo_description),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(top = 5.dp)
        )
        Button(
            onClick = { navController.navigate("vocabulary_screen") },
            modifier = Modifier
                .width(230.dp)
                .padding(top = 70.dp)
        ) {
            Text(
                text = stringResource(id = R.string.vocabulary),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodySmall
            )
        }
        Button(
            onClick = { navController.navigate("translator_screen") },
            modifier = Modifier
                .width(230.dp)
                .padding(top = 10.dp)
        ) {
            Text(
                text = stringResource(id = R.string.translator),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodySmall
            )
        }
        Button(
            onClick = { navController.navigate("chatbot_screen") },
            modifier = Modifier
                .width(230.dp)
                .padding(top = 10.dp)
        ) {
            Text(
                text = stringResource(id = R.string.chat_bot),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
