package com.example.englishguru.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bron24.bron24_android.core.presentation.theme.EnglishGuruTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EnglishGuruTheme {
                val navController = rememberNavController()
                MainNavHost(navController = navController)
            }
        }
    }
}

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "main_screen") {
        composable("main_screen") { MainScreen(navController) }
        composable("vocabulary_screen") { VocabularyScreen(navController) }
        composable("translator_screen") { TranslatorScreen(navController) }
        composable("chatbot_screen") { ChatBotScreen(navController) }
        composable("word_screen/{startWordPos}/{endWordPos}") { backStackEntry ->
            val startWordPos = backStackEntry.arguments?.getString("startWordPos")?.toInt() ?: 0
            val endWordPos = backStackEntry.arguments?.getString("endWordPos")?.toInt() ?: 0
            WordScreen(navController, startWordPos, endWordPos)
        }
    }
}
