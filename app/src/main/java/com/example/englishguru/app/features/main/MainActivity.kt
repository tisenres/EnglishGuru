package com.example.englishguru.app.features.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.englishguru.app.features.words.WordFragment
import com.example.englishguru.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(), NavigationListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Vocabulary"
                1 -> tab.text = "Pronunciation"
            }
        }.attach()
    }

    override fun navigateToAnotherFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val wordFragment = WordFragment.newInstance("ksdjsdjsd", "skdjsjkd")
        fragmentTransaction.replace(binding.viewPager.id, wordFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}