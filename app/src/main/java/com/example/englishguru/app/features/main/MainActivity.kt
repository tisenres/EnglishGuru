package com.example.englishguru.app.features.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.englishguru.app.features.vocabularySections.VocabularyFragment
import com.example.englishguru.app.features.words.WordFragment
import com.example.englishguru.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initVocabularyFragment()
    }

    private fun initVocabularyFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<VocabularyFragment>(binding.fragmentContainer.id)
        }
    }

    fun navigateToWordFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<WordFragment>(binding.fragmentContainer.id)
            addToBackStack(null)
        }
    }
}