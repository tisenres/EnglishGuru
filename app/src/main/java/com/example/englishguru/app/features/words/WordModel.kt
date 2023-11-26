package com.example.englishguru.app.features.words

import android.util.Log
import com.example.englishguru.data.IRepository
import com.example.englishguru.data.Repository
import com.example.englishguru.data.models.Word
import com.example.englishguru.data.network.Remote
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WordModel: IWordModel {

    private val repository: IRepository = Repository()
    private lateinit var currentWord: Word
//    private val wordsAPI = Remote.instance

    override fun getWord(): String {

        val disposable = Remote.instance.loadWordInfo("accurate")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                Log.d("sjdshjdjshd", response.word)
            }, { error ->
                error.printStackTrace()
            })

        return "VAVVAa"

//        currentWord = repository.getWord()
//        currentWord?.let {
//            return it.value
//        } ?: {
//            wordsAPI.getA1Words(currentWord.value)
//        }
//        return currentWord.value
    }

    override fun increaseDaysForWord(increaseNum: Int) {
        currentWord.dateToShow.date += increaseNum
        currentWord.wasShown = true
        repository.updateWord(currentWord)
    }



    override fun loadAllWords() {
//        if (!repository.wordsAreLoaded) {
//            val disposable = wordsAPI.loadAllWords()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ wordList ->
//                    repository.addWords(wordList)
//                }, { error ->
//                    error.stackTrace
//                })
//        }

//        val disposable = wordsAPI.loadWordInfo("accurate")
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ word ->
//                Log.d("sjdshjdjshd", word.word)
//            }, { error ->
//                error.stackTrace
//            })
    }

}