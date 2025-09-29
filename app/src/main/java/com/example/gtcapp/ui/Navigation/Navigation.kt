package com.example.gtcapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gtcapp.ui.screens.*

// Rutas de navegación
object Routes {
    const val LOGIN = "Login"
    const val HOME = "Home"
    const val QR_CODE = "CodigoQR"
    const val PAYMENTS = "Payments"
    const val TRANSFERS = "Transfers"
    const val SAVINGS = "AhorroScreen"
}
