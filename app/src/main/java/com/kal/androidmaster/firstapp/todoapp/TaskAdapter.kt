package com.kal.androidmaster.firstapp.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kal.androidmaster.R

class TaskAdapter(private val task:List<Task>) : RecyclerView.Adapter<TaskViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo_task, parent,false)
        return  TaskViewHolder(view)
    }

    override fun getItemCount() = task.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.render(task[position])
    }
}