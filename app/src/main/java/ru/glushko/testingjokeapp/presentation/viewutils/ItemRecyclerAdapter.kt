package ru.glushko.testingjokeapp.presentation.viewutils

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.glushko.testingjokeapp.databinding.JokeRecyclerItemBinding
import ru.glushko.testingjokeapp.domain.model.Joke
import ru.glushko.testingjokeapp.presentation.viewutils.ItemDiffCallback
import ru.glushko.testingjokeapp.presentation.viewutils.ItemViewHolder

class ItemRecyclerAdapter : ListAdapter<Joke, ItemViewHolder>(ItemDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = JokeRecyclerItemBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val itemElement = getItem(position)
        with(holder.jokeRecyclerItem) {
            positionCountText.text = "${position+1}"
            itemJoke.text = itemElement.joke
        }
    }
}