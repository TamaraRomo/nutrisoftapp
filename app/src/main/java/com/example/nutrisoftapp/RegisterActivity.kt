package com.example.nutrisoftapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import database.DatabaseBuilder // Asegúrate de tener el import correcto aquí
import database.User
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {

    private lateinit var editTextFullName: EditText
    private lateinit var editTextProfessionalId: EditText
    private lateinit var editTextPhone: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var checkBoxTerms: CheckBox
    private lateinit var buttonRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Inicializar las referencias
        editTextFullName = findViewById(R.id.editTextFullName)
        editTextProfessionalId = findViewById(R.id.editTextProfessionalId)
        editTextPhone = findViewById(R.id.editTextPhone)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        checkBoxTerms = findViewById(R.id.checkBoxTerms)
        buttonRegister = findViewById(R.id.buttonRegister)

        buttonRegister.setOnClickListener {
            if (validateForm()) {
                registerUser()
            }
        }
    }

    private fun validateForm(): Boolean {
        // Asegurarse de que todos los campos estén llenos y que los términos estén aceptados
        if (editTextFullName.text.isBlank() ||
            editTextProfessionalId.text.isBlank() ||
            editTextPhone.text.isBlank() ||
            editTextEmail.text.isBlank() ||
            editTextPassword.text.isBlank()) {
            Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_LONG).show()
            return false
        }

        if (!checkBoxTerms.isChecked) {
            Toast.makeText(this, "Debes aceptar los términos y condiciones.", Toast.LENGTH_LONG).show()
            return false
        }

        return true
    }

    private fun registerUser() {
        val fullName = editTextFullName.text.toString()
        val professionalId = editTextProfessionalId.text.toString()
        val phone = editTextPhone.text.toString()
        val email = editTextEmail.text.toString()
        val password = editTextPassword.text.toString()

        lifecycleScope.launch {
            val db = DatabaseBuilder.getInstance(applicationContext) // Uso correcto de DatabaseBuilder
            val existingUser = db.userDao().getUserByEmail(email)

            if (existingUser == null) {
                val user = User(0, fullName, professionalId, phone, email, password)
                db.userDao().insert(user)
                Toast.makeText(this@RegisterActivity, "Registro exitoso.", Toast.LENGTH_LONG).show()
                finish()
            } else {
                Toast.makeText(this@RegisterActivity, "El correo electrónico ya está en uso.", Toast.LENGTH_LONG).show()
            }
        }
    }
}
