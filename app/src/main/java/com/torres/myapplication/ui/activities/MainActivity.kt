package com.torres.myapplication.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.torres.myapplication.data.local.repository.ListUsers
import com.torres.myapplication.databinding.ActivityMainBinding
import com.torres.myapplication.logic.usercases.LoginUserCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
    }

    private fun initListeners() {
        binding.btnLogin.setOnClickListener {

            val loginUserCase = LoginUserCase(ListUsers())

            val result = loginUserCase(
                binding.etxtUser.text.toString(),
                binding.etxtPassword.text.toString()
            )

            result.onSuccess { user ->
                val intentToConstarintAct = Intent(
                    this,
                    ConstrainActivity::class.java
                ).apply {
                    putExtra("idUser", user.id)
                }
                startActivity(intentToConstarintAct)
            }

            result.onFailure {
                Toast.makeText(
                    this,
                    it.message.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}