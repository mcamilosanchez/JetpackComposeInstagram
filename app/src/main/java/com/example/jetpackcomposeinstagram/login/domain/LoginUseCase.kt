package com.example.jetpackcomposeinstagram.login.domain

import com.example.jetpackcomposeinstagram.login.data.LoginRepository
import javax.inject.Inject

//VIDEO #97: Domain
//VIDEO #101: Injecting Data and Domain
class LoginUseCase @Inject constructor(private val repository: LoginRepository) {

    ////VIDEO #101: Injecting Data and Domain: Debido a que estamos implemnentando DI, ya no es
    // necesario la siguiente instacia
    //private val repository = LoginRepository()

    /*Cuando definimos "operator fun invoke", podemos invocar una instancia de la clase
    directamente, sin necesidad de llamar explícitamente a un método.*/
    suspend operator fun invoke(user:String, password:String):Boolean{
        return repository.doLogin(user, password)
    }
}