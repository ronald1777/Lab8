package com.example.gtcapp.ui.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gtcapp.ui.screens.LoginScreen
import com.example.gtcapp.ui.screens.QRCodeScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),

) {
    NavHost(
        navController = navController,
        startDestination = Appscreens.LOGIN.route
    ){
        composable(Appscreens.LOGIN.route){
            LoginScreen(
                onLoginClick={
                    navController.navigate(Appscreens.HOME.route)
                }
            )

        }
        composable(Appscreens.QR_CODE.route){
            QRCodeScreen(
                onNavigateToSavings = {
                    navController.navigate(Appscreens.SAVINGS.route)
                },
                onNavigateToPayments = {
                    navController.navigate(Appscreens.PAYMENTS.route)
                },




            )
        }
    }
}