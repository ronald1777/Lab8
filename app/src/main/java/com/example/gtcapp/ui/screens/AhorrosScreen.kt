package com.example.gtcapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Ahorro(
    val nombre: String,
    val tipo: String,
    val monto: String
)

@Composable
fun AhorrosScreen(onBack: () -> Unit) {
    val listaAhorros = listOf(
        Ahorro("Ahorro Programado", "Cuenta de Ahorro", "Q 1,234.56"),
        Ahorro("Ahorro Flexible", "Cuenta de Ahorro", "Q 7,890.12"),
        Ahorro("Ahorro Infantil", "Cuenta de Ahorro", "Q 3,456.78")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ahorros") },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Atrás")
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
                    label = { Text("Inicio") },
                    selected = false,
                    onClick = { /* Navegar a Inicio */ }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.CreditCard, contentDescription = "Pagos") },
                    label = { Text("Pagos") },
                    selected = false,
                    onClick = { /* Navegar a Pagos */ }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Send, contentDescription = "Transferencias") },
                    label = { Text("Transferencias") },
                    selected = false,
                    onClick = { /* Navegar a Transferencias */ }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Savings, contentDescription = "Ahorros") },
                    label = { Text("Ahorros") },
                    selected = true,
                    onClick = { /* Ya estás en Ahorros */ }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.MoreHoriz, contentDescription = "Más") },
                    label = { Text("Más") },
                    selected = false,
                    onClick = { /* Navegar a Más */ }
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            items(listaAhorros) { ahorro ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    shape = MaterialTheme.shapes.medium,
                    elevation = CardDefaults.cardElevation(2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(ahorro.nombre, style = MaterialTheme.typography.titleMedium)
                            Text(
                                ahorro.tipo,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                            )
                        }
                        Text(
                            ahorro.monto,
                            fontSize = 16.sp,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}