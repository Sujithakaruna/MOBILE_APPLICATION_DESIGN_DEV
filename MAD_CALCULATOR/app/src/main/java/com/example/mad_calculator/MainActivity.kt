package com.example.mad_calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val et1 = findViewById<EditText>(R.id.et1)
        val et2 = findViewById<EditText>(R.id.et2)
        val result = findViewById<TextView>(R.id.txtResult)

        // Addition
        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            val a = et1.text.toString().toDouble()
            val b = et2.text.toString().toDouble()
            result.text = "${a + b}"
        }

        // Subtraction
        findViewById<Button>(R.id.btnSub).setOnClickListener {
            val a = et1.text.toString().toDouble()
            val b = et2.text.toString().toDouble()
            result.text = "${a - b}"
        }

        // Multiplication
        findViewById<Button>(R.id.btnMul).setOnClickListener {
            val a = et1.text.toString().toDouble()
            val b = et2.text.toString().toDouble()
            result.text = "${a * b}"
        }

        // Division
        findViewById<Button>(R.id.btnDiv).setOnClickListener {
            val a = et1.text.toString().toDouble()
            val b = et2.text.toString().toDouble()
            result.text = "${a / b}"
        }

        // Modulus
        findViewById<Button>(R.id.btnMod).setOnClickListener {
            val a = et1.text.toString().toDouble()
            val b = et2.text.toString().toDouble()
            result.text = "${a % b}"
        }
    }
}