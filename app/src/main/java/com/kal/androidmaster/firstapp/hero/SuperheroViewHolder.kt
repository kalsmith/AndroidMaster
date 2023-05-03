package com.kal.androidmaster.firstapp.hero

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kal.androidmaster.databinding.ItemSuperheroBinding

class SuperheroViewHolder(view : View): RecyclerView.ViewHolder(view){

    private val binding = ItemSuperheroBinding.bind(view)
    fun bind(superheroItemResponse: SuperheroItemResponse){
        binding.SuperheroName.text = superheroItemResponse.name
    }
}