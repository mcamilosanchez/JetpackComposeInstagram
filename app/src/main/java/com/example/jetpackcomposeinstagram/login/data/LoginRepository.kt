package com.example.jetpackcomposeinstagram.login.data

import com.example.jetpackcomposeinstagram.login.data.network.LoginService
import javax.inject.Inject


class LoginRepository @Inject constructor(private val api: LoginService) {
    //Ya no necesitamos la siguiente instancia ya que en el paso anterior realizamos DI
    // private val api = LoginService()

    suspend fun doLogin(user:String, password: String): Boolean {
        return api.doLogin(user, password)
    }

}