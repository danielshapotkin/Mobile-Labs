package com.example.lab22


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var radioGroupTemperature: RadioGroup
    private lateinit var imageViewTemperature: ImageView
    private lateinit var checkMilk: CheckBox
    private lateinit var checkCream: CheckBox
    private lateinit var checkSugar: CheckBox
    private lateinit var checkSyrup: CheckBox
    private lateinit var spinnerDelivery: Spinner
    private lateinit var buttonDeliver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroupTemperature = findViewById(R.id.radioGroupTemperature)
        imageViewTemperature = findViewById(R.id.imageViewTemperature)
        checkMilk = findViewById(R.id.checkMilk)
        checkCream = findViewById(R.id.checkCream)
        checkSugar = findViewById(R.id.checkSugar)
        checkSyrup = findViewById(R.id.checkSyrup)
        spinnerDelivery = findViewById(R.id.spinnerDelivery)
        buttonDeliver = findViewById(R.id.buttonDeliver)

        // Установка адаптера для спиннера
        val deliveryOptions = arrayOf("Самовывоз", "Доставка")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, deliveryOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerDelivery.adapter = adapter

        // Обработка изменения температуры
        radioGroupTemperature.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radioHot -> imageViewTemperature.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.red))
                R.id.radioCold -> imageViewTemperature.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.blue))
            }
        }

        // Обработка нажатия кнопки "Доставить"
        buttonDeliver.setOnClickListener {
            deliverOrder()
        }
    }

    private fun deliverOrder() {
        val temperature = if (radioGroupTemperature.checkedRadioButtonId == R.id.radioHot) "Горячий" else "Холодный"

        val ingredients = mutableListOf<String>()
        if (checkMilk.isChecked) ingredients.add("Молоко")
        if (checkCream.isChecked) ingredients.add("Сливки")
        if (checkSugar.isChecked) ingredients.add("Сахар")
        if (checkSyrup.isChecked) ingredients.add("Сироп")

        val deliveryMethod = spinnerDelivery.selectedItem.toString()

        val orderDescription = "Вы заказали $temperature кофе с добавками: ${ingredients.joinToString(", ")}. Способ доставки: $deliveryMethod."

        // Открытие новой активности с описанием заказа
        val intent = Intent(this, OrderSummaryActivity::class.java).apply {
            putExtra("ORDER_DESCRIPTION", orderDescription)
            putExtra("STUDENT_NAME", "Ваше ФИО") // Замените на вашу фамилию
        }
        startActivity(intent)
    }
}

}
}