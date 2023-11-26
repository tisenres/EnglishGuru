package com.example.englishguru.data

import com.example.englishguru.data.db.WordDao
import com.example.englishguru.data.db.WordDto
import com.example.englishguru.data.models.Word

class Repository: IRepository {

    private val wordDao: WordDao = WordDao()

    override fun getWordInfo(): Word {
        val wordDao = wordDao.getWord()
        return Word(
            value = wordDao.word,
            dateToShow = wordDao.dateToShow,
            wasShown = wordDao.wasShown,
            definition = wordDao.definition
        )
    }

    override fun updateWord(word: Word) {
        val wordDto = WordDto(

        )
        wordDao.updateWord(wordDto)
    }
}