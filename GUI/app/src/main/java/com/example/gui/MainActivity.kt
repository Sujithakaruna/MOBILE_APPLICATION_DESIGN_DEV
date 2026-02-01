package com.example.gui

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var textSizeValue = 28f
    private var textColorIndex = 0
    private var bgColorIndex = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layout = findViewById<LinearLayout>(R.id.mainLayout)
        val tvText = findViewById<TextView>(R.id.tvText)
        val btnIncrease = findViewById<Button>(R.id.btnIncrease)
        val btnColor = findViewById<Button>(R.id.btnColor)
        val btnBgColor = findViewById<Button>(R.id.btnBgColor)

        btnIncrease.setOnClickListener {
            textSizeValue += 4
            tvText.textSize = textSizeValue
        }

        btnColor.setOnClickListener {
            val textColors = arrayOf(
                Color.RED,
                Color.BLUE,
                Color.GREEN,
                Color.BLACK
            )
            tvText.setTextColor(textColors[textColorIndex])
            textColorIndex = (textColorIndex + 1) % textColors.size
        }

        btnBgColor.setOnClickListener {
            val bgColors = arrayOf(
                Color.WHITE,
                Color.LTGRAY,
                Color.YELLOW,
                Color.CYAN
            )
            layout.setBackgroundColor(bgColors[bgColorIndex])
            bgColorIndex = (bgColorIndex + 1) % bgColors.size
        }
    }
}
