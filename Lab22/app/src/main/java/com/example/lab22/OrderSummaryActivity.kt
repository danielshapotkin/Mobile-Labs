package com.example.lab22


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class OrderSummaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_summary)

        val orderDescription = intent.getStringExtra("ORDER_DESCRIPTION")
        val studentName = intent.getStringExtra("STUDENT_NAME")

        val textViewOrderSummary = findViewById<TextView>(R.id.textViewOrderSummary)
        textViewOrderSummary.text = orderDescription

        Toast.makeText(this, "Заказ от $studentName", Toast.LENGTH_LONG).show()
    }
}
