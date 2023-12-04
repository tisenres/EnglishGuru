package com.example.englishguru.app.features.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.englishguru.R
import com.example.englishguru.app.features.chatbot.ChatBotFragment
import com.example.englishguru.app.features.translator.TranslatorFragment
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

        initMainScreenFragment()
    }

    private fun initMainScreenFragment() {
        supportFragmentManager.commit {
            setCustomAnimations(R.anim.fade_fast, android.R.anim.fade_out)
            setReorderingAllowed(true)
            supportFragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            add<MainScreenFragment>(binding.fragmentContainer.id)
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

    fun navigateToVocabularyFragment() {
        supportFragmentManager.commit {
            setCustomAnimations(R.anim.fade_fast, android.R.anim.fade_out)
            setReorderingAllowed(true)
            replace<VocabularyFragment>(containerViewId = binding.fragmentContainer.id)
            addToBackStack(null)
        }
    }

    fun navigateToTranslatorFragment() {
        supportFragmentManager.commit {
            setCustomAnimations(R.anim.fade_fast, android.R.anim.fade_out)
            setReorderingAllowed(true)
            replace<TranslatorFragment>(containerViewId = binding.fragmentContainer.id)
            addToBackStack(null)
        }
    }

    fun navigateToChatBotFragment() {
        supportFragmentManager.commit {
            setCustomAnimations(R.anim.fade_fast, android.R.anim.fade_out)
            setReorderingAllowed(true)
            replace<ChatBotFragment>(containerViewId = binding.fragmentContainer.id)
            addToBackStack(null)
        }
    }
}