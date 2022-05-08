package com.example.tmdb.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdb.databinding.ItemGenreBinding


/**
 * Created by Gal Reshef on 5/5/2022.
 */
class GenreAdapter : ListAdapter<String, RecyclerView.ViewHolder>(GenreDiffCallback()) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as GenreViewHolder).bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return GenreViewHolder.from(parent)
    }

    class GenreViewHolder private constructor(private val binding: ItemGenreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            itemView.context.resources
            binding.tvGenre.text = item
        }

        companion object {
            fun from(parent: ViewGroup): GenreViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemGenreBinding
                    .inflate(layoutInflater, parent, false)
                return GenreViewHolder(binding)
            }
        }
    }
}

class GenreDiffCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem.length == newItem.length
    }
    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem.length == newItem.length
    }
}

