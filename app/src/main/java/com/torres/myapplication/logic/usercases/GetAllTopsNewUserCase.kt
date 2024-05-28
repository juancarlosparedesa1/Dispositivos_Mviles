package com.torres.myapplication.logic.usercases

import com.torres.myapplication.data.network.endpoints.NewsEndpoint
import com.torres.myapplication.data.network.entities.topNews.Data
import com.torres.myapplication.data.network.repository.RetrofitBase

class GetAllTopsNewUserCase {


    suspend operator fun invoke(): Result<List<Data>?> {

        var response = RetrofitBase.returnBaseRetrofitNews()
            .create(NewsEndpoint::class.java)
            .getAllTopNews()
        return if (response.isSuccessful) {
            Result.success(response.body()?.data)
        } else {
            Result.failure(Exception("Ocurrio un error en la API"))
        }
    }
}