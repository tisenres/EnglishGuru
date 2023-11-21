package com.example.englishguru.app.features.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.englishguru.app.features.vocabularySections.VocabularyFragment
import com.example.englishguru.app.features.words.WordFragment
import com.example.englishguru.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<VocabularyFragment>(binding.fragmentContainer.id)
        }
    }

    fun navigateToWordFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val wordFragment = WordFragment.newInstance("ksdjsdjsd", "skdjsjkd")
        fragmentTransaction.replace(binding.fragmentContainer.id, wordFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}