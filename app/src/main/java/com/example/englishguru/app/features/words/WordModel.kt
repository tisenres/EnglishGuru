package com.example.englishguru.app.features.words

import com.example.englishguru.data.models.Word
import com.example.englishguru.data.network.IRemote
import com.example.englishguru.data.repository.IRepository
import io.reactivex.disposables.Disposable
import org.koin.java.KoinJavaComponent.getKoin

const val TOTAL_NUMBER_OF_WORDS = 4617

class WordModel(private val port: OutputPortModel): IWordModel {

    private val sharedPrefsRepo: IRepository = getKoin().get()
    private val remote: IRemote = getKoin().get()

    private var currentWord: Word? = null
    private var currentWordStr: String? = null

    private var wordFetchDisposable: Disposable? = null

    override fun assignRandomWord() {
        currentWordStr = sharedPrefsRepo.getWord((0 until TOTAL_NUMBER_OF_WORDS).random())
    }

    override fun getWord(): String {
        return currentWordStr ?: ""
    }

    override fun getWordInfo(): Word {
        return currentWord?.let {
            currentWord
        } ?: Word(word = "Not defined",
            definition = "Word is NOT LOADAED!"
        )
    }

    override fun fetchWordDataRemotely() {
        val queryWord = currentWordStr ?: return

        wordFetchDisposable?.dispose()

        wordFetchDisposable = remote.fetchWordDataRemotely(queryWord)
            .subscribe({ response ->
                val localWord = Word(
                    word = response.word,
                    definition = response.results.firstOrNull()?.definition ?: "",
                    partOfSpeech = response.results.firstOrNull()?.partOfSpeech ?: "",
                    synonyms = response.results.firstOrNull()?.synonyms ?: emptyList(),
                    derivation = response.results.firstOrNull()?.derivation ?: emptyList(),
                    examples = response.results.firstOrNull()?.examples ?: emptyList(),
                    similarTo = response.results.firstOrNull()?.similarTo ?: emptyList()
                )
                currentWord = localWord
                port.onFetchComplete(localWord)
            }, { error ->
                error.printStackTrace()
            })
    }

    override fun onDestroyView() {
        wordFetchDisposable?.dispose()
    }

    override fun increaseDaysForWord(increaseNum: Int) {
//        currentWord.dateToShow += increaseNum
//        currentWord.wasShown = true
    }
}