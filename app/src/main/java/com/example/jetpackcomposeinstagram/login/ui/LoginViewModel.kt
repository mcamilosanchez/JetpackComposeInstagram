package com.example.jetpackcomposeinstagram.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    /*This variable can only be accessed from the ViewModel*/
    private val _email = MutableLiveData<String>()
    /*This variable can only be modified from here.*/
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable: LiveData<Boolean> = _isLoginEnable

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
}