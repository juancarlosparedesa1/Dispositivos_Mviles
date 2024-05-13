package com.paredes.mythirdapp

import java.lang.Exception

class LoginUserCase {

    operator fun invoke(
        user: String,
        password: String
    ): Result<Int> {
        return if (user == "admin" && password == "admin") {
            Result.success(45)
            //return true
        } else {
            Result.failure(Exception("Error de usuario o contraseña"))
            //return false
        }
    }
}