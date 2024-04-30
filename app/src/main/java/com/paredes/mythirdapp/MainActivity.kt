package com.paredes.mythirdapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.paredes.mythirdapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //var btnLogin=findViewById<Button>(R.id.btn_login)

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       /* etxtUser = findViewById<EditText>(R.id.etxt_user)


        var btnLogin = findViewById<Button>(R.id.btn_login)
        var etxtUser = findViewById<EditText>(R.id.etxt_user)
        var etxtPassword = findViewById<EditText>(R.id.etxt_password)*/

        binding.

        binding.btnLogin.setOnClickListener {
            if (etxtUser.text.toString() == "admin" && etxtPassword.text.toString() == "admin") {
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "Credenciales incorrectas!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}