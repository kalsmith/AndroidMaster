package com.kal.androidmaster.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.kal.androidmaster.R
import com.kal.androidmaster.firstapp.imccalculator.ImcCalculatorActivity
import com.kal.androidmaster.firstapp.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnTODO = findViewById<Button>(R.id.btnTODO)
        btnSaludApp.setOnClickListener { navigateToSaludApp() }
        btnIMCApp.setOnClickListener { navigateToIMCApp() }
        btnTODO.setOnClickListener { navigateToTodoApp() }

    }

    private fun navigateToTodoApp() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToIMCApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludApp() {
        val intent = Intent(this, FirstActivity::class.java)
        startActivity(intent)
    }




}