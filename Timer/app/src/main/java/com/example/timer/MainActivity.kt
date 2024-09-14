package com.example.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var isRunning: Boolean = false
    private var seconds: Int = 0
    private lateinit var tw: TextView
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tw = findViewById(R.id.tw)
        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnStop = findViewById<Button>(R.id.btnStop)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnStart.setOnClickListener {
            isRunning = true
            runTimer()
        }

        btnStop.setOnClickListener {
            isRunning = false
        }

        btnReset.setOnClickListener {
            isRunning = false // Stop the timer first
            seconds = 0
            updateTimerText() // Update the display to show reset time
        }
    }

    private fun runTimer() {
        if (isRunning) {
            seconds++
            updateTimerText()   
            handler.postDelayed({ runTimer() }, 1000)
        }
    }

    private fun updateTimerText() {
        val hours = seconds / 3600
        val minutes = (seconds % 3600) / 60
        val secs = seconds % 60
        val time = String.format("%02d:%02d:%02d", hours, minutes, secs)
        tw.text = time
    }
}
