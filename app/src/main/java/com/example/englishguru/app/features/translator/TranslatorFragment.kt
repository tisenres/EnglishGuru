package com.example.englishguru.app.features.translator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.englishguru.R
import com.example.englishguru.app.features.translator.models.LanguageModel
import com.example.englishguru.databinding.FragmentTranslatorBinding
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class TranslatorFragment: Fragment(), ITranslatorView, AdapterView.OnItemSelectedListener {

    private lateinit var binding: FragmentTranslatorBinding
    private val presenter: ITranslatorPresenter by inject { parametersOf(this) }

    private var sourceLangCodeSelection: String = LanguageModel.getLanguageCodeByName("English")
    private var targetLangCodeSelection: String = LanguageModel.getLanguageCodeByName("English")
    private lateinit var spinnerAdapter: ArrayAdapter<CharSequence>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTranslatorBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListeners()
        initSpinnerAdapter()
        initSpinners()
    }

    private fun initSpinnerAdapter() {
        spinnerAdapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.lang_array,
            android.R.layout.simple_spinner_item
        )
    }

    private fun initSpinners() {
        spinnerAdapter.also { adapter ->
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
             if (textToTranslate.isNotBlank()) {
                 presenter.onTranslateButtonPressed(textToTranslate, sourceLangCodeSelection, targetLangCodeSelection)
             } else {
                 Toast.makeText(requireContext(), "Type something to translate", Toast.LENGTH_SHORT).show()
             }
        }

        binding.swapLangBtn.setOnClickListener {
            val sourcePos = spinnerAdapter.getPosition(LanguageModel.getLanguageNameByCode(sourceLangCodeSelection))
            val targetPos = spinnerAdapter.getPosition(LanguageModel.getLanguageNameByCode(targetLangCodeSelection))

            binding.sourceSpinner.setSelection(targetPos)
            binding.targetSpinner.setSelection(sourcePos)
        }
    }

    override fun initTargetTextField(text: String) {
        binding.targetText.text = text
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (parent?.id) {
            R.id.sourceSpinner -> {
                val selectedSourceLanguage = parent.getItemAtPosition(position) as String
                sourceLangCodeSelection = LanguageModel.getLanguageCodeByName(selectedSourceLanguage)
                binding.sourceHeader.text = selectedSourceLanguage
            }
            R.id.targetSpinner -> {
                val selectedTargetLanguage = parent.getItemAtPosition(position) as String
                targetLangCodeSelection = LanguageModel.getLanguageCodeByName(selectedTargetLanguage)
                binding.targetHeader.text = selectedTargetLanguage
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}