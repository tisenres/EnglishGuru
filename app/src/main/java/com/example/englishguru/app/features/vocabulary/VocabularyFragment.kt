package com.example.englishguru.app.features.vocabulary

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.englishguru.databinding.FragmentVocabularyBinding

class VocabularyFragment : Fragment(), IVocabularyView {

    private lateinit var binding: FragmentVocabularyBinding
    private lateinit var adapter: SectionsAdapter
    private lateinit var presenter: IVocabularyPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentVocabularyBinding.inflate(layoutInflater)
        adapter = SectionsAdapter()
        presenter = VocabularyPresenter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.sectionsRv.layoutManager = LinearLayoutManager(requireContext())
        binding.sectionsRv.adapter = adapter
    }
}