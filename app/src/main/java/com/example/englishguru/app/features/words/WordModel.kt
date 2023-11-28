package com.example.englishguru.app.features.words

import android.content.Context
import com.example.englishguru.data.SharedPrefsRepository
import com.example.englishguru.data.models.Word
import com.example.englishguru.data.network.Remote
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime

const val TOTAL_NUMBER_OF_WORDS = 2978

class WordModel(context: Context): IWordModel {

    private val sharedPrefsRepo: SharedPrefsRepository = SharedPrefsRepository(context)
    private lateinit var currentWord: Word
    private val wordsAPI = Remote.instance
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun getWord(): String {
        val wordStr = sharedPrefsRepo.getWord((0..TOTAL_NUMBER_OF_WORDS).random())
        fetchWordDataRemotely(wordStr)
        return wordStr
    }

    override fun getWordInfo(): Word {
        return currentWord
    }

    override fun increaseDaysForWord(increaseNum: Int) {
//        currentWord.dateToShow += increaseNum
//        currentWord.wasShown = true
    }

    private fun fetchWordDataRemotely(wordValue: String) {
        coroutineScope.launch(Dispatchers.IO) {
            try {
                val response = wordsAPI.loadWordInfo(wordValue)
                currentWord = Word(
                    word = response.word,
                    definition = response.results[0].definition,
                    partOfSpeech = response.results[0].partOfSpeech ?: "",
                    synonyms = response.results[0].synonyms,
                    derivation = response.results[0].derivation ?: emptyList(),
                    examples = response.results[0].examples
                    )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}