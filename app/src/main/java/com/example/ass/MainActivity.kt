package com.example.ass
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById(R.id.spinner11)
        spinner.onItemSelectedListener = this


        val currency = arrayOf("USD", "EUR", "QAR", "INR")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            currency
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        val button: Button = findViewById(R.id.button11)
        button.setOnClickListener {
            val currency = spinner.selectedItem.toString()
            val rate = getExchangeRate(currency)
            val message = "1 $currency = $rate JOD"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

        }
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {}

    override fun onNothingSelected(parent: AdapterView<*>?) {}

        private fun getExchangeRate(currency: String): Double {

            when (currency) {
                "USD" -> return 0.71
                "EUR" -> return 0.76
                "QAR" -> return 0.19
                "INR" -> return 0.0086
            }
            return 0.0


    }




}