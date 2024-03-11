package com.example.nutrisoftapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class NuevoCliente : AppCompatActivity() {

    private lateinit var etNombreCompleto: EditText
    private lateinit var etNumeroTelefono: EditText
    private lateinit var etCorreoElectronico: EditText
    private lateinit var etDomicilio: EditText
    private lateinit var etTipoSangre: EditText
    private lateinit var etAlergias: EditText
    private lateinit var etEnfermedadesCronicas: EditText
    private lateinit var etTratamientoMedico: EditText
    private lateinit var btnFinalizar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cliente_nuevo) // Asegúrate de tener el nombre correcto de tu archivo XML aquí

        // Inicialización de las vistas
        etNombreCompleto = findViewById(R.id.etNombreCompleto)
        etNumeroTelefono = findViewById(R.id.etNumeroTelefono)
        etCorreoElectronico = findViewById(R.id.etCorreoElectronico)
        etDomicilio = findViewById(R.id.etDomicilio)
        etTipoSangre = findViewById(R.id.etTipoSangre)
        etAlergias = findViewById(R.id.etAlergias)
        etEnfermedadesCronicas = findViewById(R.id.etEnfermedadesCronicas)
        etTratamientoMedico = findViewById(R.id.etTratamientoMedico)
        btnFinalizar = findViewById(R.id.btnFinalizar)

        btnFinalizar.setOnClickListener {
            finalizarRegistro()
        }
    }

    private fun finalizarRegistro() {
        // Aquí manejas lo que sucede cuando el usuario hace clic en "Finalizar"
        // Por ejemplo, podrías validar los campos o guardar la información en una base de datos

        val nombreCompleto = etNombreCompleto.text.toString().trim()
        val numeroTelefono = etNumeroTelefono.text.toString().trim()
        val correoElectronico = etCorreoElectronico.text.toString().trim()
        val domicilio = etDomicilio.text.toString().trim()
        val tipoSangre = etTipoSangre.text.toString().trim()
        val alergias = etAlergias.text.toString().trim()
        val enfermedadesCronicas = etEnfermedadesCronicas.text.toString().trim()
        val tratamientoMedico = etTratamientoMedico.text.toString().trim()

        // Puedes hacer una comprobación simple como ejemplo
        if (nombreCompleto.isEmpty() || numeroTelefono.isEmpty() || correoElectronico.isEmpty()) {
            // Mostrar algún mensaje de error o realizar alguna acción
            // Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_LONG).show()
        } else {
            // Proceso para guardar los datos o avanzar a la siguiente pantalla
        }
    }
}
