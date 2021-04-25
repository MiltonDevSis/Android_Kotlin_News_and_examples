package com.example.kotlinflow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinflow.databinding.ItemLanguageBinding

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private val languages: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(languages[position])
    }

    override fun getItemCount() = languages.count()

    fun addLanguage(language: String) {
        languages.add(language)
        notifyItemInserted(itemCount)
    }

    class MainViewHolder(
        private val binding: ItemLanguageBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(language: String) {
            binding.textLanguage.text = language
        }

        companion object {
            fun create(
                parent: ViewGroup
            ): MainViewHolder {
                val itemBinding = ItemLanguageBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)

                return MainViewHolder(itemBinding)
            }
        }
    }
}