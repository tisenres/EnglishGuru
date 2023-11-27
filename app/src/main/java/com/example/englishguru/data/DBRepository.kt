package com.example.englishguru.data

import com.example.englishguru.data.db.WordDao
import com.example.englishguru.data.db.WordDto
import com.example.englishguru.data.models.Word

class DBRepository {

    private val wordDao: WordDao = WordDao()
    private var wordsAreLoadedInPrefs: Boolean = false

    fun getWordInfo(): Word {
        val wordDao = wordDao.getWord()
        return Word(
            value = wordDao.word,
            dateToShow = wordDao.dateToShow,
            wasShown = wordDao.wasShown,
            definition = wordDao.definition
        )
    }

    fun updateWordInfo(word: Word) {
        val wordDto = WordDto(

        )
        wordDao.updateWord(wordDto)
    }
}