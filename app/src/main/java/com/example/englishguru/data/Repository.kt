package com.example.englishguru.data

import android.util.Log
import com.example.englishguru.data.models.Word
import java.util.Date

class Repository: IRepository {

    private val testStorage = mutableListOf<Word>()

//    init {
//        for (i in 0 until 10) {
//            testStorage.add(Word("Word $i", Date()))
//        }
//    }

    override val wordsAreLoaded: Boolean
        get() = testStorage.isNotEmpty()

    override fun getWord(): Word {
        val filter = testStorage.filter {
            it.dateToShow.day == Date().day
        }

        val numberOfWordsShown = filter.count { it.wasShown }

        return if (numberOfWordsShown == 0) {
            filter.shuffled().first()
        } else {
            filter.shuffled().first {
                it.wasShown
            }
        }
    }

    override fun updateWord(word: Word) {
        testStorage.filter {
            it == word
        }.map {
            it.dateToShow = word.dateToShow
            it.wasShown = word.wasShown
        }
    }

    override fun addWords(wordList: List<String>) {
        testStorage.addAll(wordList.map {
            Word(it, Date())
        })
    }
}