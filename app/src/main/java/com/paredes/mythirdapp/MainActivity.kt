package com.paredes.mythirdapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.paredes.mythirdapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Sin bindig
        /* var btnLogin = findViewById<Button>(R.id.btn_login)
         var etxtUser = findViewById<EditText>(R.id.etxt_user)
         var etxtPassword = findViewById<EditText>(R.id.etxt_password)

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
*/

        //con bindign
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //con binding
        binding.btnLogin.setOnClickListener {
            if (binding.etxtUser.text.toString() == "admin" && binding.etxtPassword.text.toString() == "admin") {
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "Credenciales incorrectas!", Toast.LENGTH_SHORT).show()
            }

        }


    }

    override fun onStart() {
        super.onStart()
        Log.d("UCE","Metodo onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("UCE","Metodo onResume")
    }
}