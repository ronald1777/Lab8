package com.example.gtcapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private const val TAB_HOME = "Inicio"
private const val TAB_PAGOS = "Pagos"
private const val TAB_TRANSFER = "Transferir"
private const val TAB_AHORROS = "Ahorros"
private const val TAB_MAS = "Más"

@Composable
fun BottomNavigationBar(
    selectedItem: String,
    onNavigateToHome: () -> Unit,
    onNavigateToPayments: () -> Unit,
    onNavigateToTransfers: () -> Unit,
    onNavigateToSavings: () -> Unit,
    onNavigateToMore: () -> Unit
) {
    NavigationBar {
        NavigationBarItem(
            selected = selectedItem == TAB_HOME,
            onClick = onNavigateToHome,
            icon = { Icon(Icons.Default.Home, contentDescription = TAB_HOME) },
            label = { Text(TAB_HOME) }
        )
        NavigationBarItem(
            selected = selectedItem == TAB_PAGOS,
            onClick = onNavigateToPayments,
            icon = { Icon(Icons.Default.Payments, contentDescription = TAB_PAGOS) },
            label = { Text(TAB_PAGOS) }
        )
        NavigationBarItem(
            selected = selectedItem == TAB_TRANSFER,
            onClick = onNavigateToTransfers,
            icon = { Icon(Icons.Default.SwapHoriz, contentDescription = TAB_TRANSFER) },
            label = { Text(TAB_TRANSFER) }
        )
        NavigationBarItem(
            selected = selectedItem == TAB_AHORROS,
            onClick = onNavigateToSavings,
            icon = { Icon(Icons.Default.Savings, contentDescription = TAB_AHORROS) },
            label = { Text(TAB_AHORROS) }
        )
        NavigationBarItem(
            selected = selectedItem == TAB_MAS,
            onClick = onNavigateToMore,
            icon = { Icon(Icons.Default.MoreHoriz, contentDescription = TAB_MAS) },
            label = { Text(TAB_MAS) }
        )
    }
}
