package com.paredes.mythirdapp.logic.usercases

import com.paredes.mythirdapp.data.local.UserClass
import com.paredes.mythirdapp.data.local.repository.ListUsers
import java.lang.Exception

class LoginUserCase (val listUsers: ListUsers){


    operator fun invoke(
        user: String,
        password: String
    ): Result<UserClass> {

        var us=listUsers.checkUserPassword(user,password)


         return if (us!=null) {
           Result.success(us)
           //return true
       } else {
           Result.failure(Exception("Error de usuario o contraseña"))
           //return false
       }


       /* return if (user == "admin" && password == "admin") {
            Result.success(45)
            //return true
        } else {
            Result.failure(Exception("Error de usuario o contraseña"))
            //return false
        }*/
    }
}