package com.torres.myapplication.logic.usercases

import com.torres.myapplication.data.network.endpoints.NewsEndpoint
import com.torres.myapplication.data.network.entities.topNews.Data
import com.torres.myapplication.data.network.repository.RetrofitBase
import com.torres.myapplication.ui.entities.NewsDataUI

class GetAllTopsNewUserCase {


    suspend operator fun invoke(): Result<List<NewsDataUI>> {
        var items = ArrayList<NewsDataUI>()
        var response = RetrofitBase.returnBaseRetrofitNews()
            .create(NewsEndpoint::class.java)
            .getAllTopNews()
        return if (response.isSuccessful) {
            val x = response.body()?.data
            x!!.forEach {
                items.add(
                    NewsDataUI(
                        it.uuid,
                        it.url,
                        it.title,
                        it.image_url,
                        it.description
                    )
                )
            }
            Result.success(items.toList())
        } else {
            Result.failure(Exception("Ocurrio un error en la API"))
        }
    }
}