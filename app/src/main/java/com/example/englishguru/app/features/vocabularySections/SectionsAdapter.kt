package com.example.englishguru.app.features.vocabularySections

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.englishguru.R
import com.example.englishguru.databinding.VocabularySectionItemBinding

const val NUMBER_OF_SECTIONS = 5

class SectionsAdapter(private val presenter: IVocabularyPresenter): RecyclerView.Adapter<SectionsAdapter.SectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val binding = VocabularySectionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SectionViewHolder(binding)
    }

    override fun getItemCount(): Int = NUMBER_OF_SECTIONS

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bind(position)
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

            binding.card.setOnClickListener {
                val pos = adapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    presenter.onButtonPressed(pos)
                }
            }
        }

        fun bind(position: Int) {
            binding.sectionName.text = presenter.getSectionName(position)
            binding.sectionDescription.text = presenter.getSectionDescription(position)
            val image = when (position) {
                0 -> R.drawable.imagea1
                1 -> R.drawable.imagea2
                2 -> R.drawable.imageb1
                3 -> R.drawable.imageb2
                else -> R.drawable.imagec1
            }
            binding.sectionImage.setImageResource(image)
        }
    }
}
