package com.example.englishguru.app.features.vocabularySections

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.englishguru.app.features.main.MainActivity
import com.example.englishguru.databinding.FragmentVocabularyBinding

class VocabularyFragment: Fragment(), IVocabularyView {

    private lateinit var binding: FragmentVocabularyBinding
    private lateinit var adapter: SectionsAdapter
    private lateinit var presenter: IVocabularyPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = VocabularyPresenter(this)
        adapter = SectionsAdapter(presenter)
    }

    override fun navigateToWordFragment(startWordPos: Int, endWordPos: Int) {
        val mainActivity = activity as? MainActivity
        mainActivity?.navigateToWordFragment(startWordPos, endWordPos)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVocabularyBinding.inflate(inflater, container, false)
        return binding.root
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