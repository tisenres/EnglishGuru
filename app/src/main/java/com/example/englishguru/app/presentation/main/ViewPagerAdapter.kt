package com.example.englishguru.app.presentation.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.englishguru.app.presentation.pronounce.PronounceFragment
import com.example.englishguru.app.presentation.vocabulary.VocabularyFragment


class ViewPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> VocabularyFragment()
            1 -> PronounceFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}
