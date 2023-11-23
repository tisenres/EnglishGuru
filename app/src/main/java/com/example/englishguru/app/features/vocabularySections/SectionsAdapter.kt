package com.example.englishguru.app.features.vocabularySections

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.englishguru.databinding.VocabularySectionItemBinding

class SectionsAdapter(private val presenter: IVocabularyPresenter): RecyclerView.Adapter<SectionsAdapter.SectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val binding = VocabularySectionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SectionViewHolder(binding)
    }

    override fun getItemCount(): Int = 4

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {

    }

    inner class SectionViewHolder(private val binding: VocabularySectionItemBinding): ViewHolder(binding.root) {

        init {
            initSetOnClickListeners()
        }

        private fun initSetOnClickListeners() {
            binding.button.setOnClickListener {
                val pos = adapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    presenter.onButtonPressed(pos)
                }
            }
        }
    }
}
