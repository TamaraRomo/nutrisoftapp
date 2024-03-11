package com.example.nutrisoftapp

import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity

class RegistroNuevaConsulta : AppCompatActivity() {
    private lateinit var buttonSearchUser: Button
    private lateinit var datePicker: DatePicker
    private lateinit var timePicker: TimePicker
    private lateinit var buttonFinish: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.consulta_nueva)

        buttonSearchUser = findViewById(R.id.buttonSearchUser)
        datePicker = findViewById(R.id.datePicker)
        timePicker = findViewById(R.id.timePicker)
        buttonFinish = findViewById(R.id.buttonFinish)

        buttonSearchUser.setOnClickListener {
            // Aquí puedes realizar la consulta a la base de datos para obtener los usuarios
            // y mostrarlos en una lista o en otro componente visual
        }

        buttonFinish.setOnClickListener {
            // Obtener la fecha seleccionada
            val year = datePicker.year
            val month = datePicker.month + 1 // Se suma 1 porque los meses se indexan desde 0
            val day = datePicker.dayOfMonth

            // Obtener la hora seleccionada
            val hour = timePicker.currentHour
            val minute = timePicker.currentMinute

            // Aquí puedes guardar la fecha y la hora en la base de datos utilizando SQL
            // por ejemplo, ejecutando una sentencia INSERT INTO

            // Después de guardar los datos, puedes navegar a otra pantalla
            // o realizar otras operaciones relacionadas con la finalización de la consulta
        }

        // Configurar el botón de atrás para que regrese a otra pantalla
        val buttonBack: Button = findViewById(R.id.buttonBack)
        buttonBack.setOnClickListener {
            // Aquí puedes agregar la lógica para regresar a la pantalla anterior
            // por ejemplo, utilizando el método onBackPressed()
            onBackPressed()
        }
    }
}
