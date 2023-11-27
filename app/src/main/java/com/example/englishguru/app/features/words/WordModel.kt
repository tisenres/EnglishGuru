package com.example.englishguru.app.features.words

import android.content.Context
import com.example.englishguru.data.DBRepository
import com.example.englishguru.data.SharedPrefsRepository
import com.example.englishguru.data.models.Word
import com.example.englishguru.data.network.Remote

class WordModel(private val context: Context): IWordModel {

    private val dbRepo: DBRepository = DBRepository()
    private val sharedPrefsRepo: SharedPrefsRepository = SharedPrefsRepository(context)
    private lateinit var currentWord: Word
    private val wordsAPI = Remote.instance

    override fun getWord(): String {

        return sharedPrefsRepo.getWord((0..1995).random())

//        currentWord = repository.getWordInfo()

//        currentWord = Word(repository.getWord()

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
        dbRepo.updateWordInfo(currentWord)
    }
}