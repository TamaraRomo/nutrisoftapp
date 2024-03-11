package com.example.nutrisoftapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.nutrisoftapp.R

class DatosClientes : AppCompatActivity() {
    private lateinit var buttonAvance: Button
    private lateinit var buttonPlan: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cliente_datos)

        buttonAvance = findViewById(R.id.button3)

        buttonAvance.setOnClickListener {
            val intent = Intent(this, HistorialAvance::class.java)
            startActivity(intent)
        }

        buttonPlan = findViewById(R.id.button2)

        buttonPlan.setOnClickListener {
            val intent = Intent(this, DietaActivity::class.java)
            startActivity(intent)
        }

    }
}
