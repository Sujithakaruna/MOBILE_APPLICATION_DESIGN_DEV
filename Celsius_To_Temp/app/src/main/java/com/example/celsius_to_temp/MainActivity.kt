package com.example.celsius_to_temp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etTemp = findViewById<EditText>(R.id.etTemp)
        val btnToF = findViewById<Button>(R.id.btnToF)
        val btnToC = findViewById<Button>(R.id.btnToC)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnToF.setOnClickListener {
            val value = etTemp.text.toString().toDoubleOrNull()
            if (value == null) {
                tvResult.text = "Enter number"
                return@setOnClickListener
            }
            val result = (value * 9 / 5) + 32
            tvResult.text = "Fahrenheit: $result"
        }

        btnToC.setOnClickListener {
            val value = etTemp.text.toString().toDoubleOrNull()
            if (value == null) {
                tvResult.text = "Enter number"
                return@setOnClickListener
            }
            val result = (value - 32) * 5 / 9
            tvResult.text = "Celsius: $result"
        }
    }
}
