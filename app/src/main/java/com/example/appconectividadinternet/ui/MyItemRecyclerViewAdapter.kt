package com.example.appconectividadinternet.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil3.load
import com.example.appconectividadinternet.data.remote.PokemonSingleGetData

import com.example.appconectividadinternet.placeholder.PlaceholderContent.PlaceholderItem
import com.example.appconectividadinternet.databinding.FragmentItemBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private val values: List<PokemonSingleGetData>
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item:PokemonSingleGetData = values[position]
        holder.idView.text = item.name
        holder.img.load(item.sprites.front_default)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.name
        var img:ImageView =binding.image
        override fun toString(): String {
            return super.toString() + " '" /*+ contentView.text +*/+ "'"
        }
    }

}