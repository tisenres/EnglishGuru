package com.example.englishguru.app.features.words

import android.util.Log
import com.example.englishguru.data.IRepository
import com.example.englishguru.data.Repository
import com.example.englishguru.data.db.WordDto
import com.example.englishguru.data.models.Word
import com.example.englishguru.data.network.Remote
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WordModel: IWordModel {

    private val repository: IRepository = Repository()
    private lateinit var currentWord: Word
    private val wordsAPI = Remote.instance

    override fun getWord(): String {

//        currentWord = repository.getWordInfo()

        val disposable = wordsAPI.loadWordInfo("accurate")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                Log.d("sjdshjdjshd", response.word)
            }, { error ->
                error.printStackTrace()
            })

        return "VAVVAa"
    }

    override fun increaseDaysForWord(increaseNum: Int) {
        currentWord.dateToShow += increaseNum
        currentWord.wasShown = true
        repository.updateWord(currentWord)
    }
}