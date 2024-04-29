package com.paredes.mysecondapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var etxUser = findViewById<EditText>(R.id.etxt_user)
        var etxPassword = findViewById<EditText>(R.id.etxt_password)
        var btnLogin = findViewById<Button>(R.id.btn_login)

        btnLogin.setOnClickListener {
            if (etxUser.text.toString() == "admin" &&
                etxPassword.text.toString() == "admin") {
//                Toast.makeText(this,
//                    "Bienvenido", Toast.LENGTH_SHORT)
//                    .show()
                Snackbar.make(etxUser,"Bienvenido",Snackbar.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,
                    "Hay un error en los datos ingresados", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }
}