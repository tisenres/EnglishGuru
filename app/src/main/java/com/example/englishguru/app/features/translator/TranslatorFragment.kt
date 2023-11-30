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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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

        val deeplApiKey = "YOUR_DEEPL_API_KEY"

        presenter.translateText("Hello, world!", "en", "es", deeplApiKey)
    }
}