package com.example.englishguru.features.vocabularySections

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.englishguru.app.features.main.MainActivity
import com.example.englishguru.databinding.FragmentVocabularyBinding
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class VocabularyFragment: Fragment(), IVocabularyView {

    private lateinit var binding: FragmentVocabularyBinding
    private lateinit var adapter: SectionsAdapter
    private val presenter: IVocabularyPresenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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