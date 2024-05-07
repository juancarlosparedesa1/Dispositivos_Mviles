package com.paredes.mythirdapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.paredes.mythirdapp.databinding.ActivityConstraintBinding
import com.paredes.mythirdapp.databinding.ActivityMainBinding

class ConstraintActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConstraintBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConstraintBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonIngresar.setOnClickListener {
            if (binding.editTextUser.text.toString() == "user" && binding.editTextPassword.text.toString()=="password") {
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Usuario y/o contraseña mal ingresados", Toast.LENGTH_SHORT).show()

            }

        }


    }
}