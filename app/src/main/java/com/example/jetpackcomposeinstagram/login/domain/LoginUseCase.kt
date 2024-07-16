package com.example.jetpackcomposeinstagram.login.domain

import com.example.jetpackcomposeinstagram.login.data.LoginRepository

//VIDEO #97: Domain
class LoginUseCase {
    private val repository = LoginRepository()
    /*Cuando definimos "operator fun invoke", podemos invocar una instancia de la clase
    directamente, sin necesidad de llamar explícitamente a un método.*/
    suspend operator fun invoke(user:String, password:String):Boolean{
        return repository.doLogin(user, password)
    }
}