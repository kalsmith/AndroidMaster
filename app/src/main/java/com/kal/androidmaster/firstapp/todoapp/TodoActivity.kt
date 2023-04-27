package com.kal.androidmaster.firstapp.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kal.androidmaster.R
import com.kal.androidmaster.firstapp.todoapp.TaskCategory.*


class TodoActivity : AppCompatActivity() {

    private lateinit var rvCategories:RecyclerView
    private lateinit var categoriesAdapter: CategoryAdapter

    private lateinit var rvTask: RecyclerView
    private lateinit var taskAdapter: TaskAdapter

    private lateinit var fabAddTask: FloatingActionButton

    private val categories = listOf(
        Business,
        Personal,
        Other
    )

    private val tasks = mutableListOf(
        Task("PRUEBA NEGOCIOS", Business),
        Task("PRUEBA PERSONAL", Personal),
        Task("PRUEBA OTROS", Other)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponent()
        initUI()
        initListener()

    }

    private fun initListener() {
        fabAddTask.setOnClickListener{ showDialog()}
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)
        dialog.show()
    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTask = findViewById(R.id.rvTask)
        fabAddTask = findViewById(R.id.fabAddTask)
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