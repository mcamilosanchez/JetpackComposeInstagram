package com.example.jetpackcomposeinstagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposeinstagram.login.ui.LoginScreen
import com.example.jetpackcomposeinstagram.login.ui.LoginViewModel
import com.example.jetpackcomposeinstagram.ui.theme.JetpackComposeInstagramTheme
import dagger.hilt.android.AndroidEntryPoint


//Video #100: Con esta etiqueta, ya tenemos esta Activity preparada para DI
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    //Video #100: Con la anotación "viewModels" estamos preparando el VM e inyectarlo.
    // Con esto nos olvidamos de crear instancias a mano
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeInstagramTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Sin DI
                    //LoginScreen(LoginViewModel())
                    //Con DI
                    LoginScreen(loginViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeInstagramTheme {
        Greeting("Android")
    }
}