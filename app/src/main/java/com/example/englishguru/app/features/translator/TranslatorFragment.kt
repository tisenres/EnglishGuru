package com.example.englishguru.app.features.translator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.englishguru.R
import com.example.englishguru.databinding.FragmentTranslatorBinding

class TranslatorFragment : Fragment(), ITranslatorView, AdapterView.OnItemSelectedListener {

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
        initSpinners()
    }

    private fun initSpinners() {
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.lang_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.sourceSpinner.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.lang_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.targetSpinner.adapter = adapter
        }

        binding.sourceSpinner.onItemSelectedListener = this
        binding.targetSpinner.onItemSelectedListener = this
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

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (parent?.id) {
            R.id.sourceSpinner -> {
                val selectedSourceLanguage = parent.getItemAtPosition(position) as String
                presenter.getLanguageByPos(selectedSourceLanguage)
            }
            R.id.targetSpinner -> {
                val selectedTargetLanguage = parent.getItemAtPosition(position) as String
//                presenter.getLanguageByPos(selectedTargetLanguage)
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}