package com.example.englishguru.data

import android.content.Context
import android.content.SharedPreferences
import com.example.englishguru.R
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class SharedPrefsRepository(private val context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private var wordsAreLoadedInPrefs = CompletableDeferred<Boolean>()

//    fun getWord(): String {
//        if (!wordsAreLoadedInPrefs) {
//            loadWordsInSharedPrefs()
//            wordsAreLoadedInPrefs = true
//        }
//        return getStringFromPrefs("word_${(0..5000).random()}")
//    }
//
//    private fun loadWordsInSharedPrefs() {
//        coroutineScope.launch {
//            try {
//                withContext(Dispatchers.IO) {
//                    val inputStream = context.resources.openRawResource(R.raw.oxford5000)
//                    inputStream.use { stream ->
//                        val inputStreamReader = InputStreamReader(stream)
//                        val bufferedReader = BufferedReader(inputStreamReader)
//
//                        val wordList = mutableListOf<Pair<String, String>>()
//                        var line: String?
//                        var counter = 0
//
//                        while (bufferedReader.readLine().also { line = it } != null) {
//                            wordList.add("word_$counter" to (line ?: ""))
//                            counter++
//                        }
//
//                        saveStringListInPrefs(wordList)
//                    }
//                }
//            } catch (e: IOException) {
//                e.printStackTrace()
//            }
//        }
//    }
//
//    private fun saveStringListInPrefs(wordList: List<Pair<String, String>>) {
//        editor.apply {
//            wordList.forEach { (key, value) ->
//                putString(key, value)
//            }
//            apply()
//        }
//    }
//
//    private fun getStringFromPrefs(key: String): String {
//        return sharedPreferences.getString(key, "Not defined") ?: "Not defined"
//    }

    fun getWord(index: Int): String {
        if (!wordsAreLoadedInPrefs.isCompleted) {
            loadWordsInSharedPrefs()
        }
        return getStringFromPrefs("word_$index")
    }

    private fun loadWordsInSharedPrefs() {
        coroutineScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    val inputStream = context.resources.openRawResource(R.raw.oxford5000)
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
                    }
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
