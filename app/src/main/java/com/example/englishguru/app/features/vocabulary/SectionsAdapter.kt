package com.example.englishguru.app.features.vocabulary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.englishguru.databinding.VocabularySectionItemBinding

class SectionsAdapter: RecyclerView.Adapter<SectionsAdapter.SectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val binding = VocabularySectionItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SectionViewHolder(binding)
    }

    override fun getItemCount(): Int = 4

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bind("sjdjsdhjsdjhsd")
    }

    inner class SectionViewHolder(private val binding: VocabularySectionItemBinding): ViewHolder(binding.root) {
        fun bind(item: String) {

        }
    }

}
