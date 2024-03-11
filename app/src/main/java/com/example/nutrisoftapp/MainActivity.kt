package com.example.nutrisoftapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {


    private lateinit var buttonCliente: ImageButton
    private lateinit var buttonConsulta: ImageButton
    private lateinit var buttonLogout: Button
    private lateinit var buttonPerfil: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCliente = findViewById(R.id.clientesBtn)

        buttonCliente.setOnClickListener {
            val intent = Intent(this, ClienteActivity::class.java)
            startActivity(intent)
        }
        buttonConsulta = findViewById(R.id.consultasBtn)
        buttonConsulta.setOnClickListener {
            val intent = Intent(this, ConsultaActivity::class.java)
            startActivity(intent)
        }

        buttonPerfil = findViewById(R.id.perfilBtn)

        buttonPerfil.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        buttonLogout = findViewById(R.id.button)


    }


    }
