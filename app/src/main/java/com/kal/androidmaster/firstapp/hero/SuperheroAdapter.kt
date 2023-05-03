package com.kal.androidmaster.firstapp.hero

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SuperheroAdapter(var superheroList: List<SuperheroItemResponse> = emptyList()) :
    RecyclerView.Adapter<SuperheroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        1:11:15
    }

    override fun onBindViewHolder(viewholder: SuperheroViewHolder, position: Int) {
        viewholder.bind(superheroList[position])

    }

    override fun getItemCount() = superheroList.size

}