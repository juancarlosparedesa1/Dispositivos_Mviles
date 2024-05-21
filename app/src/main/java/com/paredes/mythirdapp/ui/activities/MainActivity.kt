package com.paredes.mythirdapp.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.paredes.mythirdapp.data.local.repository.ListUsers
import com.paredes.mythirdapp.logic.usercases.LoginUserCase
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

        initListeners()

        /*  //con binding
         binding.btnLogin.setOnClickListener {
            if (binding.etxtUser.text.toString() == "admin" && binding.etxtPassword.text.toString() == "admin") {
                 Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()

             } else {
                 Toast.makeText(this, "Credenciales incorrectas!", Toast.LENGTH_SHORT).show()
             }*/

    }

    private fun initListeners() {
        binding.btnLogin.setOnClickListener {
            //Capturo
            var loginUserCase = LoginUserCase(ListUsers()) //instancia(ahora inyeccion de dependencias)

            var result = loginUserCase(//setear
                binding.etxtUser.text.toString(),
                binding.etxtPassword.text.toString()
            )
            //desempaquetamos
            result.onSuccess {user->
                var intentToConstraintActivity = Intent(
                    this,
                    ConstraintActivity::class.java
                ).apply {
                    putExtra("idUser",user.id)
                }
                startActivity(intentToConstraintActivity)
            }

            result.onFailure {
                Toast.makeText(
                    this,
                    it.message.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }

            //valida con if si el usuario y la contraseña son validos
            //esto lo hicimos aqui, comentado porque ya existe un UserCase
            /*  if (binding.etxtUser.text.toString() == "admin" && binding.etxtPassword.text.toString() == "admin") {
                  Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()
                  startActivity(a)

              } else {
                  Toast.makeText(this, "Credenciales incorrectas!", Toast.LENGTH_SHORT).show()
              }*/
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("UCE", "Metodo onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("UCE", "Metodo onResume")
    }


}


