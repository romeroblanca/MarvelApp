package com.romeroblanca.marvelapp.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.romeroblanca.marvelapp.domain.model.CharacterModel
import com.romeroblanca.marvelapp.domain.model.CharactersListModel
import com.romeroblanca.marvelapp.databinding.ItemCharacterBinding

open class ListAdapter(
    private val characters: CharactersListModel
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RecyclerView.ViewHolder {
        return ListViewHolder(ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return characters.list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ListViewHolder).bind(characters.list[position])
    }

    class ListViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CharacterModel) {
            binding.tvCharacter.text = item.name
        }
    }
}