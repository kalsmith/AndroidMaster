package com.kal.androidmaster.firstapp.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.kal.androidmaster.R
import com.kal.androidmaster.firstapp.imccalculator.ImcCalculatorActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponents()
        initUI(result)

    }

    private fun initUI(result: Double) {
        tvIMC.text = result.toString()
        when(result){
            in 0.00..18.50 ->{ //BAJO PESO
                tvResult.text = getString(R.string.title_bajo_peso)
                tvDescription.text = getString(R.string.description_bajo_peso)
            }
            in 18.51..24.99 ->{ // PESO NORMAL
                tvResult.text = getString(R.string.title_peso_normal)
                tvDescription.text = getString(R.string.description_peso_normal)
            }

            in 25.00..29.99 ->{ //SOBREPESO
                tvResult.text = getString(R.string.title_sobre_peso)
                tvDescription.text = getString(R.string.description_sobre_peso)
            }

            in 30.00..99.00 ->{ //OBESIDAD
                tvResult.text = getString(R.string.title_obesidad)
                tvDescription.text = getString(R.string.description_obesidad)
            }
            else -> { // ERROR
                tvIMC.text = getString(R.string.error)
                tvResult.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)

            }

        }

    }

    private fun initComponents() {
        tvIMC = findViewById(R.id.tvIMC)
        tvResult = findViewById(R.id.tvResult)
        tvDescription = findViewById(R.id.tvDescription)
    }
}