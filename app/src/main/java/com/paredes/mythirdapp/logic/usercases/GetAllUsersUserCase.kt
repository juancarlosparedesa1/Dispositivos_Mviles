package com.paredes.mythirdapp.logic.usercases

import android.util.Log
import com.paredes.mythirdapp.data.network.endpoints.UsersEndpoint
import com.paredes.mythirdapp.data.network.repository.RetrofitBase

class GetAllUsersUserCase {
    suspend operator fun invoke(){
        val call=RetrofitBase.returnBaseRetrofit()
        val service=call.create(UsersEndpoint::class.java)
        val response=service.getAllUsers()

        if (response.isSuccessful){
            val body=response.body()
            Log.d("RSP",body.toString())
        }else{
            Log.d("RSP","La Ejecución fallo")

        }
    }
    }