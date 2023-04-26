package com.kal.androidmaster.firstapp.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kal.androidmaster.R




class TodoActivity : AppCompatActivity() {

    private lateinit var rvCategories:RecyclerView
    private lateinit var categoriesAdapter: CategoryAdapter

    private val categories = listOf(
        TaskCategory.Business,
        TaskCategory.Personal,
        TaskCategory.Other
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponent()
        initUI()

    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
    }

    private fun initUI() {
        categoriesAdapter = CategoryAdapter(categories)
        rvCategories.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter
    }
}