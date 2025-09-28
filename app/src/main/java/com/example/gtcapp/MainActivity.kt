package com.example.gtcapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gtcapp.ui.screens.LoginScreen
import com.example.gtcapp.ui.theme.GTCAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GTCAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    LoginScreen(
                        onLoginClick = {
                            println("Login clicked")
                        },
                        onForgotPasswordClick = {
                            println("Forgot password clicked")
                        },
                        onBiometricClick = {
                            println("Biometric login clicked")
                        },
                        onFaceClick = {
                            println("Face login clicked")
                        },
                        onQRPaymentClick = {
                            println("QR Payment clicked")
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GTCAppTheme {
        Greeting("Android")
    }
}
