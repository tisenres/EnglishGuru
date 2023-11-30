package com.example.englishguru.app.features.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.englishguru.app.features.chatbot.WordChatFragment
import com.example.englishguru.app.features.vocabularySections.VocabularyFragment
import com.example.englishguru.app.features.words.WordFragment
import com.example.englishguru.databinding.ActivityMainBinding

private const val START_WORD_POS = "START_WORD_POS"
private const val END_WORD_POS = "END_WORD_POS"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        initVocabularyFragment()
        initChatBotFragment()
    }

    private fun initChatBotFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<WordChatFragment>(binding.fragmentContainer.id)
        }
    }

    private fun initVocabularyFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<VocabularyFragment>(binding.fragmentContainer.id)
        }
    }

    fun navigateToWordFragment(startWordPos: Int, endWordPos: Int) {

        val bundle = Bundle()
        bundle.putInt(START_WORD_POS, startWordPos)
        bundle.putInt(END_WORD_POS, endWordPos)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<WordFragment>(containerViewId = binding.fragmentContainer.id, args = bundle)
            addToBackStack(null)
        }
    }
}