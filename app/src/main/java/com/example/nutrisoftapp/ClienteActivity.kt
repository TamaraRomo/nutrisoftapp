package com.example.nutrisoftapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ClienteActivity : AppCompatActivity() {

    private lateinit var buttonCliente: Button
    private lateinit var buttonNuevo: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clientes)

        buttonCliente = findViewById(R.id.buttonClient)


        buttonCliente.setOnClickListener {
            val intent = Intent(this, DatosClientes::class.java)
            startActivity(intent)
        }

        buttonNuevo = findViewById(R.id.buttonNuevo)

        buttonNuevo.setOnClickListener {
            val intent = Intent(this, NuevoCliente::class.java)
            startActivity(intent)
        }

    }
}