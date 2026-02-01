package com.example.count_increase

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtNumber: TextView = findViewById(R.id.txtNumber)
        val btnIncrease: Button = findViewById(R.id.btnIncrease)
        val btnDecrease: Button = findViewById(R.id.btnDecrease)

        var number = 0

        btnIncrease.setOnClickListener {
            number++
            txtNumber.text = number.toString()
        }

        btnDecrease.setOnClickListener {
            number--
            txtNumber.text = number.toString()
        }
    }
}
