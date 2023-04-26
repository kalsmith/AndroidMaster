package com.kal.androidmaster.firstapp.todoapp

sealed class TaskCategory {
    object Personal:TaskCategory()
    object Business:TaskCategory()
    object Other: TaskCategory()
}

//List<TaskCategory>