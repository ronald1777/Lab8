package com.example.gtcapp.ui.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gtcapp.navigation.Routes
import com.example.gtcapp.ui.screens.BankApp
import com.example.gtcapp.ui.screens.LoginScreen
import com.example.gtcapp.ui.screens.PaymentsScreen
import com.example.gtcapp.ui.screens.QRCodeScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()

) {
    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
    ){
        composable(Routes.LOGIN){
            LoginScreen(
                onLoginClick={
                    navController.navigate(Routes.HOME){
                        popUpTo(Routes.LOGIN){inclusive = true}
                        launchSingleTop = true
                    }
                },
                onQRPaymentClick = {navController.navigate(Routes.QR_CODE){
                    launchSingleTop = true
                }
                }
            )
        }
        composable(Routes.HOME){
            BankApp(
                onNavigateToPayments = {
                    println("click en pagos ")
                    navController.navigate(Routes.PAYMENTS) {launchSingleTop = true}
                },
                onNavigateToTransfer = {
                    println("click en transferencias ")
                    navController.navigate(Routes.TRANSFERS) {launchSingleTop = true}
                }
            )

        }
        composable(Routes.QR_CODE){
            QRCodeScreen(
                onNavigateToSavings = {
                    navController.navigate(Routes.SAVINGS)
                },
                onNavigateToPayments = {
                    navController.navigate(Routes.PAYMENTS)
                }


            )
        }
        composable(Routes.PAYMENTS){
            PaymentsScreen(
                onNavigateToHome = {
                    navController.navigate(Routes.HOME)
                },
                onNavigateToSavings = {
                    navController.navigate(Routes.SAVINGS)
                },
                onNavigateToTransfers = {
                    navController.navigate(Routes.TRANSFERS)
                },
                onNavigateToPayments = {
                }
            )

        }
    }
}