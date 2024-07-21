package com.example.jetpackcomposeinstagram.login.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

//VIDEO #101
/* Como ya realizamos la DI de Retrofit (recordar que implementamos la 4ta manera, por medio de .
Providers)*/
class LoginService @Inject constructor(private val loginClient: LoginClient) {
    //VIDEO #101
    /* Como ya realizamos la DI de Retrofit (recordar que implementamos la 4ta manera, por medio de .
    Providers). Ya no es necesario la instancia de abajo */
    //private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doLogin(user: String, password: String): Boolean {
        //Recordar que para uso de APIS o Persistencia de datos, tenemos que usar el Dispatcher.IO
        return withContext(Dispatchers.IO) {
            //dentro del create, pasamos nuestro cliente

            /** VIDEO #101: Estamos aprendiendo a cerca de la inyección de dependencias, debido a
             que response es creada a partir de instancia, podemos implementar DI. Recordar que hay
            4 maneras de realizar inyección de dependenciad, en este caso, como LoginClient es una
            interfaz, para inyectarlo debemos usar Providers. El siguiente código se usó antes de implementar DI:

            val response = retrofit.create(LoginClient::class.java).doLogin()
            response.body()?.success ?: false

             Ahora, como vamos a implementar DI, el nuevo código queda de la siguiente manera:
             **/

            val response = loginClient.doLogin()
            response.body()?.success ?: false

        }
    }
}