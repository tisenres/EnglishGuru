package com.example.englishguru.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.englishguru.R
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

const val WORDS_ARE_LOADED = "WORDS_ARE_LOADED"

class SharedPrefsRepository(private val context: Context): IRepository {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private var wordsAreLoadedInPrefs = CompletableDeferred<Boolean>()

    override fun getWord(index: Int): String {

        val wordsAreLoaded = sharedPreferences.getBoolean(WORDS_ARE_LOADED, false)

        if (!wordsAreLoaded) {
            loadWordsInSharedPrefs()
        }
        return getStringFromPrefs("word_$index")
    }

    private fun loadWordsInSharedPrefs() {
        coroutineScope.launch {
            try {
                val inputStream = context.resources.openRawResource(R.raw.oxford5000bycefr)
                inputStream.use { stream ->
                    val inputStreamReader = InputStreamReader(stream)
                    val bufferedReader = BufferedReader(inputStreamReader)

                    val wordList = mutableListOf<Pair<String, String>>()
                    var line: String?
                    var counter = 0

                    while (bufferedReader.readLine().also { line = it } != null) {
                        wordList.add("word_$counter" to (line ?: ""))
                        counter++
                    }

                    saveStringListInPrefs(wordList)
                    wordsAreLoadedInPrefs.complete(true)
                    editor.putBoolean(WORDS_ARE_LOADED, true)
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun saveStringListInPrefs(wordList: List<Pair<String, String>>) {
        editor.apply {
            wordList.forEach { (key, value) ->
                putString(key, value)
            }
            apply()
        }
    }

    private fun getStringFromPrefs(key: String): String {
        return sharedPreferences.getString(key, "Not defined") ?: "Not defined"
    }
}
