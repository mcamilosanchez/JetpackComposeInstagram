package com.example.jetpackcomposeinstagram.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeinstagram.login.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//Con esta etiqueta, ya tenemos este ViewModel preparado para DI
@HiltViewModel

class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase): ViewModel() {

    //Aquí vamos a llamar a nuestro caso de uso
    //Video #100: Este caso de uso aún no está listo para ser inyectado, por eso se comenta ésta
    // instancia
    //val loginUseCase = LoginUseCase()


    /*This variable can only be accessed from the ViewModel*/
    private val _email = MutableLiveData<String>()
    /*This variable can only be modified from here.*/
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable: LiveData<Boolean> = _isLoginEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading:LiveData<Boolean> = _isLoading

    /** With these three previous variables (Also called states), we ensure that our views can read,
     *  but not modify. **/

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLoginButton(email, password)
    }

    private fun enableLoginButton(email: String, password: String) : Boolean {
        //matches() executes the function and it RETURNS true or false
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6
    }

    //This function is called when the Login button is pressed
    fun onLoginSelected() {
        Log.i("LoginVM", "Result Perra")
        //Let's call our coroutine and our use case like this:
        viewModelScope.launch {
            _isLoading.value = true
            val result = loginUseCase(email.value!!, password.value!!)
            if (result) {
                //Navigate to the next screen
                Log.i("LoginVM", "Result OK")
            } 
            _isLoading.value = false
        }
    }
}