package com.example.mad_exercise4

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var gestureDetector: GestureDetector
    private lateinit var tv: TextView

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.tv)

        gestureDetector = GestureDetector(
            this,
            object : GestureDetector.SimpleOnGestureListener() {

                override fun onDown(e: MotionEvent): Boolean {
                    return true
                }

                override fun onLongPress(e: MotionEvent) {
                    tv.text = "Long Press"
                    Toast.makeText(this@MainActivity, "Long Press", Toast.LENGTH_SHORT).show()
                }

                override fun onDoubleTap(e: MotionEvent): Boolean {
                    tv.text = "Double Tap"
                    Toast.makeText(this@MainActivity, "Double Tap", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this@MainActivity, MainActivity2::class.java)
                    startActivity(intent)

                    return true
                }

                override fun onFling(
                    e1: MotionEvent?,
                    e2: MotionEvent,
                    velocityX: Float,
                    velocityY: Float
                ): Boolean {

                    if (e1 == null) return false

                    val diffX = e2.x - e1.x
                    val diffY = e2.y - e1.y

                    if (abs(diffX) > abs(diffY)) {
                        if (abs(diffX) > 50 && abs(velocityX) > 50) {
                            if (diffX > 0) {
                                tv.text = "Right Swipe"
                            } else {
                                tv.text = "Left Swipe"
                            }
                        }
                    } else {
                        if (abs(diffY) > 50 && abs(velocityY) > 50) {
                            if (diffY > 0) {
                                tv.text = "Down Swipe"
                            } else {
                                tv.text = "Up Swipe"
                            }
                        }
                    }

                    return true
                }
            }
        )
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event) || super.onTouchEvent(event)
    }
}