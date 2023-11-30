package com.example.englishguru.app.features.translator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.englishguru.databinding.FragmentTranslatorBinding

class TranslatorFragment : Fragment(), ITranslatorView {

    private lateinit var binding: FragmentTranslatorBinding
    private lateinit var presenter: ITranslatorPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        presenter = TranslatorPresenter(this)
        binding = FragmentTranslatorBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.translateBtn.setOnClickListener {
            val textToTranslate = binding.sourceText.text.toString()
            presenter.onTranslateButtonPressed(textToTranslate, "en", "es")
        }
    }

    override fun initTargetTextField(text: String) {
        binding.targetText.text = text
    }
}