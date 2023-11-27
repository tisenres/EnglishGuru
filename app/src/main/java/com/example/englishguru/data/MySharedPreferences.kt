package com.example.englishguru.data

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    fun saveString(word: String) {
        editor.putString((0..5000).random().toString(), word)
        editor.apply()
    }

    fun getString(): String? {
        return sharedPreferences.getString((0..5000).random().toString(), "SD")
    }
}