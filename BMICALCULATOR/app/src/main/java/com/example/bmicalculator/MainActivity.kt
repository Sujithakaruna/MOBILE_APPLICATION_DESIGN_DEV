package com.example.bmicalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etWeight = findViewById<EditText>(R.id.etWeight)
        val etHeight = findViewById<EditText>(R.id.etHeight)
        val btn = findViewById<Button>(R.id.btnCalculate)
        val tv = findViewById<TextView>(R.id.tvResult)

        btn.setOnClickListener {

            val w = etWeight.text.toString().toDoubleOrNull()
            val h = etHeight.text.toString().toDoubleOrNull()

            if (w == null || h == null || h == 0.0) {
                tv.text = "Enter valid values"
                return@setOnClickListener
            }

            val bmi = w / (h / 100).pow(2)

            val category = when {
                bmi < 18.5 -> "Underweight"
                bmi < 25 -> "Normal"
                bmi < 30 -> "Overweight"
                else -> "Obese"
            }

            tv.text = "BMI: %.2f\nCategory: %s".format(bmi, category)
        }
    }
}
