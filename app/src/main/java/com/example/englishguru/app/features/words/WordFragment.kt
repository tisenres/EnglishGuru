package com.example.englishguru.app.features.words

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.englishguru.databinding.FragmentWordBinding

class WordFragment : Fragment(), IWordView {

    private lateinit var binding: FragmentWordBinding
    private lateinit var presenter: IWordPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = WordPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentWordBinding.inflate(inflater, container, false)
        setOnClickListeners()
        initViewAppearance()
        return binding.root
    }

    private fun initViewAppearance() {
        binding.showAnswerBtn.visibility = View.VISIBLE
        binding.optionButtons.apply {
            againBtn.visibility = View.GONE
            hardBtn.visibility = View.GONE
            goodBtn.visibility = View.GONE
            easyBtn.visibility = View.GONE
        }
        binding.wordTv.text = presenter.getWord()
    }

    private fun setOnClickListeners() {
        binding.showAnswerBtn.setOnClickListener {
            binding.apply {
                showAnswerBtn.visibility = View.GONE
                optionButtons.apply {
                    againBtn.visibility = View.VISIBLE
                    hardBtn.visibility = View.VISIBLE
                    goodBtn.visibility = View.VISIBLE
                    easyBtn.visibility = View.VISIBLE
                }
            }
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun showNextWord() {
        initViewAppearance()
    }
}