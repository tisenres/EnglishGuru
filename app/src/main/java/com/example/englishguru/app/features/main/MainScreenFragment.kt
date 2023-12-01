package com.example.englishguru.app.features.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.englishguru.app.features.translator.TranslatorFragment
import com.example.englishguru.app.features.vocabularySections.VocabularyFragment
import com.example.englishguru.databinding.FragmentMainScreenBinding

class MainScreenFragment : Fragment() {
    private lateinit var binding: FragmentMainScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainScreenBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun initTranslatorFragment() {
//        parentFragmentManager.commit {
//            setReorderingAllowed(true)
//            add<TranslatorFragment>(binding.fragmentContainer.id)
//        }
    }

    private fun initVocabularyFragment() {
//        parentFragmentManager.commit {
//            setReorderingAllowed(true)
//            add<VocabularyFragment>(binding.fragmentContainer.id)
//        }
    }
}