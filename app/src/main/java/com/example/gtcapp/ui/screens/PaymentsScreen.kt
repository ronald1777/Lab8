package com.example.gtcapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
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
import com.example.gtcapp.ui.theme.GTCAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentsScreen() {
    val tabs = listOf("Servicios", "Tarjetas", "Préstamos")
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pagos") },
                navigationIcon = {
                    IconButton(onClick = { /* Acción volver */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        },

    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            // Tabs
            TabRow(selectedTabIndex = selectedTab) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = { Text(title) }
                    )
                }
            }

            // Contenido
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    Text("Mis pagos", style = MaterialTheme.typography.titleMedium)
                }

                item {
                    PagoCard("Servicios", "Agua, luz, teléfono", Icons.Default.Payment)
                }
                item {
                    PagoCard("Tarjetas", "Tarjetas de crédito", Icons.Default.Payment)
                }
                item {
                    PagoCard("Préstamos", "Préstamos", Icons.Default.Payment)
                }

                item {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Otros", style = MaterialTheme.typography.titleMedium)
                }

                item {
                    PagoCard("Agregar pago", "", Icons.Default.Add)
                }
                item {
                    PagoCard("Historial de pagos", "", Icons.Default.MoreHoriz)
                }
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
        PaymentsScreen()
    }
}