package com.example.gtcapp.ui.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gtcapp.navigation.Routes
import com.example.gtcapp.ui.screens.AhorrosScreen
import com.example.gtcapp.ui.screens.BankApp
import com.example.gtcapp.ui.screens.LoginScreen
import com.example.gtcapp.ui.screens.PaymentsScreen
import com.example.gtcapp.ui.screens.QRCodeScreen
import com.example.gtcapp.ui.screens.TransferScreen

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
                },
                onNavigateToSavings = {
                    println("click en ahorros ")
                    navController.navigate(Routes.SAVINGS) {launchSingleTop = true}
                }
            )


        }
        composable(Routes.QR_CODE){
            QRCodeScreen(
                onNavigateToHome = {
                    navController.navigate(Routes.HOME)
                },
                onNavigateToTransfers = {
                    navController.navigate(Routes.TRANSFERS)
                },

                onNavigateToSavings = {
                    navController.navigate(Routes.SAVINGS)
                },
                onNavigateToPayments = {
                    navController.navigate(Routes.PAYMENTS)
                },
                onBackClick = {
                    navController.navigate(Routes.HOME)
                },
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
        composable(Routes.SAVINGS){
            AhorrosScreen(
                onNavigateToHome = {
                    navController.navigate(Routes.HOME)
                },
                onNavigateToTransfers = {
                    navController.navigate(Routes.TRANSFERS)
                },
                onNavigateToPayments ={
                    navController.navigate(Routes.PAYMENTS)
            },
                onNavigateToSavings = {
                    navController.navigate(Routes.SAVINGS)
                }


            )

        }
        composable(Routes.TRANSFERS){
            TransferScreen(

                onTabChange = {},
                onNavigateToHome = {
                    navController.navigate(Routes.HOME)
                },
                onNavigateToPayments = {
                    navController.navigate(Routes.PAYMENTS)
                },
                onNavigateToTransfers = {
                    navController.navigate(Routes.TRANSFERS)
                },
                onNavigateToSavings = {
                    navController.navigate(Routes.SAVINGS)
                },
                onNavigateToMore = {},
                selectedTransferTab= "Cuentas Propias",
            )
        }


    }
}