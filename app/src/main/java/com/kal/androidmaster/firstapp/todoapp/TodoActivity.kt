package com.kal.androidmaster.firstapp.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kal.androidmaster.R
import com.kal.androidmaster.firstapp.todoapp.TaskCategory.*


class TodoActivity : AppCompatActivity() {

    private lateinit var rvCategories:RecyclerView
    private lateinit var categoriesAdapter: CategoryAdapter

    private lateinit var rvTask: RecyclerView
    private lateinit var taskAdapter: TaskAdapter

    private val categories = listOf(
        Business,
        Personal,
        Other
    )

    private val tasks = mutableListOf(
        Task("PRUEBA ASDT", Business),
        Task("PRUEBA PERSONA", Personal),
        Task("PRUEBA reeeeeeee", Other)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponent()
        initUI()

    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTask = findViewById(R.id.rvTask)
    }

    private fun initUI() {
        categoriesAdapter = CategoryAdapter(categories)
        rvCategories.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        taskAdapter = TaskAdapter(tasks)
        rvTask.layoutManager = LinearLayoutManager(this)
        rvTask.adapter = taskAdapter
    }
}