package com.example.gtcapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gtcapp.ui.theme.Primary

@Composable
fun BottomNavigationBar(
    selectedItem: String,
    onNavigateToHome: () -> Unit,
    onNavigateToPayments: () -> Unit,
    onNavigateToTransfers: () -> Unit,
    onNavigateToSavings: () -> Unit,
    onNavigateToMore: () -> Unit
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = "Inicio"
                )
            },
            label = { Text("Inicio", fontSize = 11.sp) },
            selected = selectedItem == "Inicio",
            onClick = onNavigateToHome,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Primary,
                selectedTextColor = Primary,
                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                indicatorColor = Color.Transparent
            )
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = if (selectedItem == "Pagos") Icons.Filled.Payment else Icons.Outlined.Payment,
                    contentDescription = "Pagos"
                )
            },
            label = {
                Text(
                    "Pagos",
                    fontSize = 11.sp,
                    fontWeight = if (selectedItem == "Pagos") FontWeight.Bold else FontWeight.Normal
                )
            },
            selected = selectedItem == "Pagos",
            onClick = onNavigateToPayments,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Primary,
                selectedTextColor = Primary,
                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                indicatorColor = Color.Transparent
            )
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Outlined.SwapHoriz,
                    contentDescription = "Transferencias"
                )
            },
            label = { Text("Transferencias", fontSize = 11.sp) },
            selected = selectedItem == "Transferencias",
            onClick = onNavigateToTransfers,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Primary,
                selectedTextColor = Primary,
                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                indicatorColor = Color.Transparent
            )
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Savings,
                    contentDescription = "Ahorros"
                )
            },
            label = { Text("Ahorros", fontSize = 11.sp) },
            selected = selectedItem == "Ahorros",
            onClick = onNavigateToSavings,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Primary,
                selectedTextColor = Primary,
                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                indicatorColor = Color.Transparent
            )
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Outlined.MoreHoriz,
                    contentDescription = "Más"
                )
            },
            label = { Text("Más", fontSize = 11.sp) },
            selected = selectedItem == "Más",
            onClick = onNavigateToMore,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Primary,
                selectedTextColor = Primary,
                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                indicatorColor = Color.Transparent
            )
        )
    }
}
