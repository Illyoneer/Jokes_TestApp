package ru.glushko.testingjokeapp.presentation.viewutils

import androidx.recyclerview.widget.DiffUtil
import ru.glushko.testingjokeapp.domain.model.Joke

class ItemDiffCallback : DiffUtil.ItemCallback<Joke>() {
    override fun areItemsTheSame(oldItem: Joke, newItem: Joke): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Joke, newItem: Joke): Boolean {
        return oldItem == newItem
    }
}