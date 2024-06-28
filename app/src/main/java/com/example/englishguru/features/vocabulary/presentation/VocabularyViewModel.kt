package com.example.englishguru.features.vocabulary.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.englishguru.features.vocabulary.domain.model.Section
import com.example.englishguru.features.vocabulary.domain.usecases.GetSectionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VocabularyViewModel @Inject constructor(
    private val getSectionsUseCase: GetSectionsUseCase
) : ViewModel() {

    private val _sections = MutableStateFlow<List<Section>>(emptyList())
    val sections: StateFlow<List<Section>> = _sections.asStateFlow()

    init {
        loadSections()
    }

    private fun loadSections() {
        viewModelScope.launch {
            getSectionsUseCase().collect { sectionsList ->
                _sections.value = sectionsList
            }
        }
    }
}