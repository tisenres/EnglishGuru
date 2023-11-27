package com.example.englishguru.data

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.englishguru.R
import com.example.englishguru.data.db.WordDao
import com.example.englishguru.data.db.WordDto
import com.example.englishguru.data.models.Word
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class Repository(private val context: Context): IRepository {

    private val wordDao: WordDao = WordDao()
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()
    private var wordsAreLoadedInPrefs: Boolean = false

    override fun getWordInfo(): Word {
        val wordDao = wordDao.getWord()
        return Word(
            value = wordDao.word,
            dateToShow = wordDao.dateToShow,
            wasShown = wordDao.wasShown,
            definition = wordDao.definition
        )
    }

    override fun getWord(): String {
        if (!wordsAreLoadedInPrefs) {
            loadWordsInSharedPrefs()
            wordsAreLoadedInPrefs = true
        }
        return sharedPreferences.getString((0..5000).random().toString(), "UA").toString()
    }

    override fun updateWord(word: Word) {
        val wordDto = WordDto(

        )
        wordDao.updateWord(wordDto)
    }

    override fun loadWordsInSharedPrefs() {

        val mySharedPreferences = MySharedPreferences(context)

        val inputStream = context.resources.openRawResource(R.raw.oxford5000)
        try {
            val inputStreamReader = InputStreamReader(inputStream)
            val bufferedReader = BufferedReader(inputStreamReader)
            var line: String
            while (bufferedReader.readLine().also { line = it } != null) {
                mySharedPreferences.saveString(line)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                inputStream.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}