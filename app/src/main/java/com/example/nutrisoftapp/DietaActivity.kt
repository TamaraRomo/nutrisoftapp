package com.example.nutrisoftapp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DietaActivity : AppCompatActivity() {

    private lateinit var metaTextView: TextView
    private lateinit var dietListView: ListView
    private lateinit var exerciseListView: ListView
    private lateinit var menuSpinner: Spinner
    private lateinit var dietaContainer: LinearLayout
    private lateinit var ejerciciosContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dieta)

        // Obtener referencias de vistas
        metaTextView = findViewById(R.id.metaTextView)
        dietListView = findViewById(R.id.dietListView)
        exerciseListView = findViewById(R.id.exerciseListView)
        menuSpinner = findViewById(R.id.menuSpinner)
        dietaContainer = findViewById(R.id.dietaContainer)
        ejerciciosContainer = findViewById(R.id.ejerciciosContainer)

        // Configurar el Spinner con opciones
        val adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
            this,
            R.array.menu_options,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        menuSpinner.adapter = adapter

        // Configurar el listener para el Spinner
        menuSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                // Mostrar la vista correspondiente según la opción seleccionada
                when (position) {
                    0 -> mostrarVistaDieta()
                    1 -> mostrarVistaEjercicios()
                }
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // No se necesita implementar en este caso
            }
        }

        // Cargar datos de ejemplo
        cargarDatosDieta()  // Implementa esta función según tus necesidades
        cargarDatosEjercicios()  // Implementa esta función según tus necesidades
    }

    private fun mostrarVistaDieta() {
        dietaContainer.visibility = View.VISIBLE
        ejerciciosContainer.visibility = View.GONE
    }

    private fun mostrarVistaEjercicios() {
        dietaContainer.visibility = View.GONE
        ejerciciosContainer.visibility = View.VISIBLE
    }

    private fun cargarDatosDieta() {
        // Implementa esta función para cargar datos de ejemplo para la dieta
    }

    private fun cargarDatosEjercicios() {
        // Implementa esta función para cargar datos de ejemplo para la lista de ejercicios
    }
}
