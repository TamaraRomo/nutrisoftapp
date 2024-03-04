package com.example.nutrisoftapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import database.DatabaseBuilder // Asegúrate de que el import sea correcto
import database.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var textViewRegister: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        textViewRegister = findViewById(R.id.textViewRegister)

        insertTestUser()

        buttonLogin.setOnClickListener {
            performLogin()
        }

        textViewRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun insertTestUser() {
        val testUser = User(0, "Test User", "123456", "1234567890", "test@example.com", "password") // Asegúrate de tener todos los campos

        lifecycleScope.launch(Dispatchers.IO) {
            val userDao = DatabaseBuilder.getInstance(applicationContext).userDao()
            userDao.insert(testUser)
        }
    }

    private fun performLogin() {
        val email = editTextEmail.text.toString().trim()
        val password = editTextPassword.text.toString().trim()

        if (validateInput(email, password)) {
            lifecycleScope.launch {
                val userDao = DatabaseBuilder.getInstance(applicationContext).userDao()
                val user = withContext(Dispatchers.IO) {
                    userDao.getUserByEmail(email)
                }

                if (user != null && user.password == password) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(applicationContext, "Inicio de sesión exitoso", Toast.LENGTH_LONG).show()
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(applicationContext, "Correo o contraseña invalida", Toast.LENGTH_LONG).show()
                    }
                }
            }
        } else {
            Toast.makeText(this, "Por favor ingresa correo electrónico y contraseña", Toast.LENGTH_LONG).show()
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        return email.isNotEmpty() && password.isNotEmpty()
    }
}
