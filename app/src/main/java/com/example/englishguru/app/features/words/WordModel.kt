package com.example.englishguru.app.features.words

import android.content.Context
import com.example.englishguru.data.DBRepository
import com.example.englishguru.data.SharedPrefsRepository
import com.example.englishguru.data.models.Word
import com.example.englishguru.data.network.Remote
import io.realm.kotlin.internal.platform.runBlocking
import java.time.LocalDateTime

const val TOTAL_NUMBER_OF_WORDS = 1995

class WordModel(context: Context): IWordModel {

    private val dbRepo: DBRepository = DBRepository()
    private val sharedPrefsRepo: SharedPrefsRepository = SharedPrefsRepository(context)
    private lateinit var currentWord: Word
    private val wordsAPI = Remote.instance

    override fun getWord(): String {

        val wordStr = sharedPrefsRepo.getWord((0..TOTAL_NUMBER_OF_WORDS).random())
        val wordPrefs = Word(
            wordStr,
            LocalDateTime.now().dayOfYear
        )

        val word = dbRepo.getWordInfo(wordPrefs)

        word?.value?.let {
            currentWord = word
        } ?: run {
            fetchWordDataRemotely(wordPrefs.value)
//            saveWordInDB()
        }

        return wordStr
    }

    override fun increaseDaysForWord(increaseNum: Int) {
        currentWord.dateToShow += increaseNum
        currentWord.wasShown = true
        dbRepo.updateWordInfo(currentWord)
    }

    override fun getWordInfo(): Word {
        return currentWord
    }

    private fun saveWordInDB() {
        TODO("Not yet implemented")
    }

    private fun fetchWordDataRemotely(wordValue: String) {
        runBlocking {
            val response = wordsAPI.loadWordInfo(wordValue)
        }
    }
}