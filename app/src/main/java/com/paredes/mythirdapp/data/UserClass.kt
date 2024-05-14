package com.paredes.mythirdapp.data

import android.util.Log

data class UserClass(
    var id: Int,
    var name: String,
    var pass: String,
)

{
    init {
        Log.d("DATA","Se contruye una nueva instancia de usuario")
    }
}