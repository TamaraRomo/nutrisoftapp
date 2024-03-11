package com.example.nutrisoftapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.nutrisoftapp.databinding.ActivityConsultasBinding

class ConsultaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConsultasBinding
    private lateinit var buttonNConsulta: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConsultasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        buttonNConsulta = findViewById(R.id.btnNuevaConsulta)


        buttonNConsulta.setOnClickListener {
            val intent = Intent(this, RegistroNuevaConsulta::class.java)
            startActivity(intent)
        }

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}
