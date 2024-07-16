package com.example.jetpackcomposeinstagram.login.data.network

import com.example.jetpackcomposeinstagram.login.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

interface LoginClient {

    /*Cuando llame a la función "doLogin", tiene que llamar al siguiente endpoint y recuperar o
    retornar (por eso los dos puntos) un objeto de tipo LoginResponse*/
    @GET("/v3/f78c9d33-28b1-4f81-9cf1-6d6ff78fa014")
    suspend fun doLogin():Response<LoginResponse>

}