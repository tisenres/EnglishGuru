package com.example.englishguru.data

import android.util.Log
import com.example.englishguru.data.models.Word
import java.util.Date

class Repository: IRepository {

    private val testStorage = mutableListOf(Word("AAAAAA", Date()), Word("SDHSDGSD", Date()), Word("sjdhshjdjhsd", Date()))

    override fun getWord(): Word {
        return testStorage.random()
    }

    override fun updateWord(word: Word) {
        Log.d("SDHSHDGSDSD", "Word: ${word.value}, Date: ${word.dateToShow}")
    }
}