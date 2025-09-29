package com.example.gtcapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gtcapp.navigation.BottomNavigationBar
import com.example.gtcapp.ui.theme.GTCAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransferScreen(
    selectedTransferTab: String,
    onTabChange: (String) -> Unit,
    onNavigateToHome: () -> Unit,
    onNavigateToPayments: () -> Unit,
    onNavigateToTransfers: () -> Unit,
    onNavigateToSavings: () -> Unit,
    onNavigateToMore: () -> Unit,
    onNewTransfer: () -> Unit = {}
) {
    val tabs = listOf("Cuentas Propias", "Terceros G&T", "Otros Bancos")

    Scaffold(
        topBar = { TopAppBar(title = { Text("Transferencias") }) },
        bottomBar = {
            BottomNavigationBar(
                selectedItem = "Transferir",
                onNavigateToHome = onNavigateToHome,
                onNavigateToPayments = onNavigateToPayments,
                onNavigateToTransfers = { /* ya estás aquí */ },
                onNavigateToSavings = onNavigateToSavings,
                onNavigateToMore = onNavigateToMore
            )
        }
    ) { paddingValues ->
        Column(Modifier.padding(paddingValues)) {

            // Tabs
            TabRow(selectedTabIndex = tabs.indexOf(selectedTransferTab)) {
                tabs.forEach { title ->
                    Tab(
                        selected = selectedTransferTab == title,
                        onClick = { onTabChange(title) },
                        text = { Text(title) }
                    )
                }
            }

            // Contenido por tab
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                when (selectedTransferTab) {
                    "Cuentas Propias" -> {
                        item { TransferCard("Cuenta Ahorros - ****1234", "Disponible Q 12,345.67") }
                        item { TransferCard("Cuenta Monetaria - ****5678", "Disponible Q 8,765.43") }
                    }
                    "Terceros G&T" -> {
                        item { TransferCard("Juan Pérez - ****9988", "G&T Continental") }
                        item { TransferCard("María López - ****7766", "G&T Continental") }
                    }
                    "Otros Bancos" -> {
                        item { TransferCard("Banco X - ****1122", "ACH habilitado") }
                        item { TransferCard("Banco Y - ****3344", "ACH habilitado") }
                    }
                }

                item {
                    Spacer(Modifier.height(8.dp))
                    Button(
                        onClick = onNewTransfer,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("＋ Nueva transferencia")
                    }
                }
            }
        }
    }
}

@Composable
private fun TransferCard(titulo: String, subtitulo: String) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(titulo, style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(4.dp))
            Text(subtitulo, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TransferScreenPreview() {
    GTCAppTheme {
        TransferScreen(
            selectedTransferTab = "Cuentas Propias",
            onTabChange = {},
            onNavigateToHome = {},
            onNavigateToPayments = {},
            onNavigateToTransfers = {},
            onNavigateToSavings = {},
            onNavigateToMore = {},
            onNewTransfer = {}
        )
    }
}

