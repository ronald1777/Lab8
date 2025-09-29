package com.example.gtcapp.ui.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gtcapp.ui.screens.*

// Rutas de navegación
sealed class Appscreens(val route: String) {
    object LOGIN : Appscreens("Login")
    object HOME: Appscreens ("Home")
    object QR_CODE: Appscreens("QR_CODE")
    object PAYMENTS : Appscreens ("Payments")
    object TRANSFERS: Appscreens ("Transfers")
    object SAVINGS : Appscreens ("Savings")
}
