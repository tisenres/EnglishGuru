package com.example.englishguru.features.words

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.englishguru.R
import com.example.englishguru.data.models.Word
import com.example.englishguru.databinding.FragmentWordBinding
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

private const val START_WORD_POS = "START_WORD_POS"
private const val END_WORD_POS = "END_WORD_POS"

class WordFragment: Fragment(), IWordView {

    private lateinit var binding: FragmentWordBinding
    private lateinit var presenter: IWordPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var startWordPos: Int? = null
        var endWordPos: Int? = null

        arguments?.let {
            startWordPos = it.getInt(START_WORD_POS)
            endWordPos = it.getInt(END_WORD_POS)
        }
        val presenter: IWordPresenter by inject { parametersOf(this, startWordPos, endWordPos) }
        this.presenter = presenter
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
        binding.showAnswerBtn.text = getString(R.string.show_answer)
        setupTitleVisibility()
    }

    private fun setupTitleVisibility() {
        binding.apply {
            wordTitle.visibility = View.VISIBLE
            showAnswerBtn.visibility = View.VISIBLE
            wordInfo.root.visibility = View.GONE
            showNextBtn.visibility = View.GONE
//            optionButtons.root.visibility = View.GONE
        }
    }

    private fun setupDetailsVisibility() {
        binding.apply {
            wordTitle.visibility = View.GONE
            showAnswerBtn.visibility = View.GONE
//            optionButtons.root.visibility = View.VISIBLE
            wordInfo.root.visibility = View.VISIBLE
            showNextBtn.visibility = View.VISIBLE

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
        binding.showNextBtn.setOnClickListener {
            presenter.onViewCreated()
        }

//        binding.optionButtons.apply {
//            againBtn.setOnClickListener {
//                presenter.onAgainButtonPressed()
//            }
//
//            hardBtn.setOnClickListener {
//                presenter.onHardButtonPressed()
//            }
//
//            goodBtn.setOnClickListener {
//                presenter.onGoodButtonPressed()
//            }
//
//            easyBtn.setOnClickListener {
//                presenter.onEasyButtonPressed()
//            }
//        }
}

//    override fun initButtonToShowNextMode() {
//        binding.showAnswerBtn.text = "Next word"
//    }

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

    override fun setUpVisibilityForEmptyCards() {
        binding.wordInfo.apply {
            if (definition.text == "") definitionCard.visibility = View.GONE
            if (examples.text == "") examplesCard.visibility = View.GONE
            if (synonyms.text == "") synonymsCard.visibility = View.GONE
            if (partOfSpeech.text == "") partOfSpeechCard.visibility = View.GONE
            if (similarTo.text == "") similarToCard.visibility = View.GONE
            if (derivation.text == "") derivationCard.visibility = View.GONE
        }
    }
}