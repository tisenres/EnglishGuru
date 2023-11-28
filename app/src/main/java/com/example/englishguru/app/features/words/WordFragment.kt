package com.example.englishguru.app.features.words

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.englishguru.data.models.Word
import com.example.englishguru.databinding.FragmentWordBinding

class WordFragment : Fragment(), IWordView {

    private lateinit var binding: FragmentWordBinding
    private lateinit var presenter: IWordPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = WordPresenter(this, requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentWordBinding.inflate(inflater, container, false)
        setOnClickListeners()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
    }

    override fun showWordTitle(wordStr: String) {
        binding.wordTitle.text = wordStr
        setupTitleVisibility()
    }

    private fun setupTitleVisibility() {
        binding.apply {
            wordTitle.visibility = View.VISIBLE
            showAnswerBtn.visibility = View.VISIBLE
            wordInfo.root.visibility = View.GONE
            optionButtons.root.visibility = View.GONE
        }
    }

    private fun setupDetailsVisibility() {
        binding.apply {
            wordTitle.visibility = View.GONE
            showAnswerBtn.visibility = View.GONE
            optionButtons.root.visibility = View.VISIBLE
            wordInfo.root.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onDestroyView()
    }

    private fun setOnClickListeners() {
        binding.showAnswerBtn.setOnClickListener {
            presenter.onShowAnswerButtonPressed()
        }

        binding.optionButtons.apply {
            againBtn.setOnClickListener {
                presenter.onAgainButtonPressed()
            }

            hardBtn.setOnClickListener {
                presenter.onHardButtonPressed()
            }

            goodBtn.setOnClickListener {
                presenter.onGoodButtonPressed()
            }

            easyBtn.setOnClickListener {
                presenter.onEasyButtonPressed()
            }
        }
    }

    override fun showWordDetails() {
        setupDetailsVisibility()
    }

    override fun fillWordDetails(wordInfo: Word) {
        binding.wordInfo.apply {
            word.text = wordInfo.word
            definition.text = wordInfo.definition
            examples.text = wordInfo.examples.joinToString("\n")
            synonyms.text = wordInfo.synonyms.joinToString("\n")
            partOfSpeech.text = wordInfo.partOfSpeech
            similarTo.text = wordInfo.similarTo.joinToString("\n")
            derivation.text = wordInfo.derivation.joinToString("\n")
        }
    }
}