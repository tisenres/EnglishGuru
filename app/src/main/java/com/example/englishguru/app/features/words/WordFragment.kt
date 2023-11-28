package com.example.englishguru.app.features.words

import android.os.Bundle
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
            wordTv.visibility = View.VISIBLE
            wordTv.text = presenter.getWord()
            optionButtons.apply {
                againBtn.visibility = View.GONE
                hardBtn.visibility = View.GONE
                goodBtn.visibility = View.GONE
                easyBtn.visibility = View.GONE
            }
            wordInfo.apply {
                text1.visibility = View.GONE
                text2.visibility = View.GONE
                text3.visibility = View.GONE
                text4.visibility = View.GONE
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
                text1.visibility = View.VISIBLE
                text2.visibility = View.VISIBLE
                text3.visibility = View.VISIBLE
                text4.visibility = View.VISIBLE
            }
        }
    }

    private fun setOnClickListeners() {
        binding.showAnswerBtn.setOnClickListener {
            binding.wordTv.text = presenter.getWord()
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
}