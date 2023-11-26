package com.example.englishguru.app.features.words

import com.example.englishguru.data.IRepository
import com.example.englishguru.data.Repository
import com.example.englishguru.data.models.Word
import com.example.englishguru.data.network.Remote

class WordModel: IWordModel {

    private val repository: IRepository = Repository()
    private lateinit var currentWord: Word
    private val wordsAPI = Remote.instance

    override fun getWord(): String {
        currentWord = repository.getWord()
        return currentWord.value
    }

    override fun increaseDaysForWord(increaseNum: Int) {
        currentWord.dateToShow.date += increaseNum
        currentWord.wasShown = true
        repository.updateWord(currentWord)
    }



}