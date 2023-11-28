package com.example.englishguru.app.features.words

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
        initViewAppearanceBeforeAnswer()
        return binding.root
    }

    private fun initViewAppearanceBeforeAnswer() {
        binding.apply {
            showAnswerBtn.visibility = View.VISIBLE
            wordTv.text = presenter.getWord()
            wordTv.visibility = View.VISIBLE
            optionButtons.apply {
                againBtn.visibility = View.GONE
                hardBtn.visibility = View.GONE
                goodBtn.visibility = View.GONE
                easyBtn.visibility = View.GONE
            }
            wordInfo.apply {
                wordCard.visibility = View.GONE
                definitionCard.visibility = View.GONE
                synonymsCard.visibility = View.GONE
                partOfSpeechCard.visibility = View.GONE
                derivationCard.visibility = View.GONE
                examplesCard.visibility = View.GONE
                similarToCard.visibility = View.GONE
            }
        }
    }

    private fun initViewAppearanceWhenWordInfo() {
        binding.apply {
            showAnswerBtn.visibility = View.GONE
            wordTv.visibility = View.GONE
            optionButtons.apply {
                againBtn.visibility = View.VISIBLE
                hardBtn.visibility = View.VISIBLE
                goodBtn.visibility = View.VISIBLE
                easyBtn.visibility = View.VISIBLE
            }
            wordInfo.apply {
                wordCard.visibility = View.VISIBLE
                definitionCard.visibility = View.VISIBLE
                synonymsCard.visibility = View.VISIBLE
                partOfSpeechCard.visibility = View.VISIBLE
                derivationCard.visibility = View.VISIBLE
                examplesCard.visibility = View.VISIBLE
                similarToCard.visibility = View.VISIBLE
            }
        }
        initWordInfoData()
    }

    private fun setOnClickListeners() {
        binding.showAnswerBtn.setOnClickListener {
            initViewAppearanceWhenWordInfo()
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

    override fun showNextWord() {
        initViewAppearanceBeforeAnswer()
    }

    private fun initWordInfoData() {
        binding.wordInfo.apply {
            word.text = presenter.getWord()
            definition.text = presenter.getDefinition()
//            similarTo.text = presenter.getSimilarTo().toString()
//            examples.text = presenter.getExamples().toString()
//            synonyms.text = presenter.getSynonyms().toString()
            partOfSpeech.text = presenter.getPartOfSpeech()
        }
    }
}