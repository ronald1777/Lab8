package com.example.gtcapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// MODELO DE DATOS
data class Account(
    val balance: String,
    val type: String,
    val icon: Int
)

@Composable
fun BankApp() {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar() }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color(0xFFF7F8FA))
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text("Cuentas", fontWeight = FontWeight.Bold, fontSize = 20.sp)

            Spacer(modifier = Modifier.height(8.dp))

            // Lista de cuentas
            AccountCard(
                account = Account("Q 12,345.67", "Cuenta de Ahorros", android.R.drawable.ic_menu_mylocation)
            )
            AccountCard(
                account = Account("Q 8,765.43", "Cuenta Monetaria", android.R.drawable.ic_menu_agenda)
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text("Acciones Rápidas", fontWeight = FontWeight.Bold, fontSize = 20.sp)

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                QuickActionButton("Transferir", Icons.Default.SwapHoriz)
                QuickActionButton("Pagar", Icons.Default.Payments)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text("G&T Continental", fontWeight = FontWeight.Bold)
        },
        actions = {
            IconButton(onClick = { /* acción */ }) {
                Icon(Icons.Default.Settings, contentDescription = "Configuración")
            }
        }
    )
}

@Composable
fun AccountCard(account: Account) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Surface(
                shape = CircleShape,
                color = Color(0xFFE3F2FD),
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    painter = painterResource(id = account.icon),
                    contentDescription = "Cuenta",
                    tint = Color(0xFF1565C0),
                    modifier = Modifier.padding(12.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(account.balance, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(account.type, color = Color.Gray, fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun QuickActionButton(text: String, icon: androidx.compose.ui.graphics.vector.ImageVector) {
    Button(
        onClick = { /* acción */ },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2)),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .height(50.dp)
    ) {
        Icon(icon, contentDescription = text, tint = Color.White)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text, color = Color.White)
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = {},
            icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
            label = { Text("Inicio") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Payments, contentDescription = "Pagos") },
            label = { Text("Pagos") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.SwapHoriz, contentDescription = "Transferir") },
            label = { Text("Transferir") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Savings, contentDescription = "Ahorros") },
            label = { Text("Ahorros") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.MoreHoriz, contentDescription = "Más") },
            label = { Text("Más") }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewBankApp() {
    BankApp()
}
