package com.kal.androidmaster.firstapp.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kal.androidmaster.R
import com.kal.androidmaster.firstapp.todoapp.TaskCategory.*
import java.text.FieldPosition


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

        val btnAddTask:Button = dialog.findViewById(R.id.btnAddTask)
        val etTask:EditText = dialog.findViewById(R.id.etTask)
        val rgCategories:RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener{
            val selectedId = rgCategories.checkedRadioButtonId
            val selectedRadioButton:RadioButton = rgCategories.findViewById(selectedId)
            val currentCategory: TaskCategory = when(selectedRadioButton.text){
                getString(R.string.todo_dialog_category_business)->Business
                getString(R.string.todo_dialog_category_personal)-> Personal
                else -> Other
            }
            tasks.add(Task(etTask.text.toString(), currentCategory))
            updateTask()
            dialog.hide()
        }


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

        taskAdapter = TaskAdapter(tasks) {position -> onItemSelected(position)}
        rvTask.layoutManager = LinearLayoutManager(this)
        rvTask.adapter = taskAdapter
    }

    private fun onItemSelected(position: Int){
        tasks[position].isSelected = !tasks[position].isSelected
        updateTask()

    }
    private fun updateTask(){
        taskAdapter.notifyDataSetChanged()
    }
}