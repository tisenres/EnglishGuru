package com.example.englishguru.features.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.englishguru.R
import com.example.englishguru.features.chatbot.ChatBotFragment
import com.example.englishguru.app.features.translator.TranslatorFragment
import com.example.englishguru.app.features.vocabularySections.VocabularyFragment
import com.example.englishguru.app.features.words.WordFragment
import com.example.englishguru.databinding.ActivityMainBinding

private const val START_WORD_POS = "START_WORD_POS"
private const val END_WORD_POS = "END_WORD_POS"

