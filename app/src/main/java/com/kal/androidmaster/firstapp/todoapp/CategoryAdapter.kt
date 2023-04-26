package com.kal.androidmaster.firstapp.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kal.androidmaster.R
import java.text.FieldPosition

class CategoryAdapter(private val categories: List<TaskCategory>):
    RecyclerView.Adapter<CategoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent, false)
        return  CategoriesViewHolder(view)

    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int){
        holder.render(categories[position])
    }

    override fun getItemCount() = categories.size
}