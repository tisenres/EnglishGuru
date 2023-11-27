package com.example.englishguru.app.features.words

import android.content.Context
import android.util.Log
import com.example.englishguru.data.IRepository
import com.example.englishguru.data.Repository
import com.example.englishguru.data.models.Word
import com.example.englishguru.data.network.Remote
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class WordModel(private val context: Context): IWordModel {

    private val repository: IRepository = Repository(context = context)
    private lateinit var currentWord: Word
    private val wordsAPI = Remote.instance

    override fun getWord(): String {

//        currentWord = repository.getWordInfo()

        return repository.getWord()

//        val disposable = wordsAPI.loadWordInfo("accurate")
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ response ->
//                Log.d("sjdshjdjshd", response.word)
//            }, { error ->
//                error.printStackTrace()
//            })
    }

    override fun increaseDaysForWord(increaseNum: Int) {
        currentWord.dateToShow += increaseNum
        currentWord.wasShown = true
        repository.updateWordInfo(currentWord)
    }
}