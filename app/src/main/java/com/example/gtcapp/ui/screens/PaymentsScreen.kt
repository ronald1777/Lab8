package com.example.gtcapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gtcapp.navigation.BottomNavigationBar
import com.example.gtcapp.ui.theme.GTCAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentsScreen(
    selectedPaymentTab: String,
    onTabChange: (String) -> Unit,
    onNavigateToHome: () -> Unit,
    onNavigateToPayments: () -> Unit,
    onNavigateToTransfers: () -> Unit,
    onNavigateToSavings: () -> Unit,
    onNavigateToMore: () -> Unit
) {
    val tabs = listOf("Servicios", "Tarjetas", "Préstamos")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pagos") }
            )
        },
        bottomBar = {
            BottomNavigationBar(
                selectedItem = "Pagos",
                onNavigateToHome = onNavigateToHome,
                onNavigateToPayments = onNavigateToPayments,
                onNavigateToTransfers = onNavigateToTransfers,
                onNavigateToSavings = onNavigateToSavings,
                onNavigateToMore = onNavigateToMore
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            // Tabs
            TabRow(selectedTabIndex = tabs.indexOf(selectedPaymentTab)) {
                tabs.forEach { title ->
                    Tab(
                        selected = selectedPaymentTab == title,
                        onClick = { onTabChange(title) },
                        text = { Text(title) }
                    )
                }
            }

            // Contenido dinámico según tab
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    Text("Mis pagos", style = MaterialTheme.typography.titleMedium)
                }

                when (selectedPaymentTab) {
                    "Servicios" -> {
                        item { PagoCard("Agua", "Pago de servicio de agua", Icons.Default.Payment) }
                        item { PagoCard("Luz", "Pago de energía eléctrica", Icons.Default.Payment) }
                        item { PagoCard("Teléfono", "Pago de telefonía", Icons.Default.Payment) }
                    }

                    "Tarjetas" -> {
                        item { PagoCard("Visa ****1234", "Tarjeta de crédito", Icons.Default.Payment) }
                        item { PagoCard("Mastercard ****5678", "Tarjeta de débito", Icons.Default.Payment) }
                    }

                    "Préstamos" -> {
                        item { PagoCard("Préstamo personal", "Saldo pendiente Q5,000", Icons.Default.Payment) }
                        item { PagoCard("Préstamo vehicular", "Saldo pendiente Q30,000", Icons.Default.Payment) }
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Otros", style = MaterialTheme.typography.titleMedium)
                }

                item { PagoCard("Agregar pago", "", Icons.Default.Add) }
                item { PagoCard("Historial de pagos", "", Icons.Default.MoreHoriz) }
            }
        }
    }
}

@Composable
fun PagoCard(titulo: String, subtitulo: String, icon: ImageVector) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, contentDescription = titulo, tint = MaterialTheme.colorScheme.primary)
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(titulo, fontSize = 16.sp, style = MaterialTheme.typography.titleMedium)
                if (subtitulo.isNotEmpty()) {
                    Text(subtitulo, fontSize = 14.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PaymentsScreenPreview() {
    GTCAppTheme {
        PaymentsScreen(
            selectedPaymentTab = "Tarjetas",
            onTabChange = {},
            onNavigateToHome = {},
            onNavigateToPayments = {},
            onNavigateToTransfers = {},
            onNavigateToSavings = {},
            onNavigateToMore = {})
    }
}
