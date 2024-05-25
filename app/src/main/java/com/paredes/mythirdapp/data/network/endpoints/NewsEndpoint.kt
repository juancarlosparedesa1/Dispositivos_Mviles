package com.paredes.mythirdapp.data.network.endpoints

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsEndpoint {
    @GET("top")
    @Headers(
        "Authenticatio Bearear :aljflasdjfoii34224" //OAUTH ESTANDAR POST Y EN CABECERA
    )
    suspend fun <T> getAllTopNews(
        @Query("api_token") apiToken: String,
        @Query("locale") locale: String,
        @Query("limit") limit: Int
    ):Response<T>

}