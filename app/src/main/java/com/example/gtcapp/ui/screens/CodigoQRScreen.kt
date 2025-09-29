package com.example.gtcapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.gtcapp.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QRCodeScreen(
    onBackClick: () -> Unit = {},
    onScanQRClick: () -> Unit = {},
    onGalleryClick: () -> Unit = {},
    onPasteLinkClick: () -> Unit = {},
    onHistoryClick: () -> Unit = {},
    onNavigateToHome: () -> Unit = {},
    onNavigateToPayments: () -> Unit = {},
    onNavigateToTransfers: () -> Unit = {},
    onNavigateToSavings: () -> Unit = {},
    onNavigateToMore: () -> Unit = {}
) {
    var selectedTab by remember { mutableStateOf("Pagar") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Código QR",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Volver",
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                },
                actions = {
                    // Spacer para centrar el título
                    Spacer(modifier = Modifier.width(48.dp))
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.onBackground
                )
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Tab selector (Pagar / Cobrar)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        MaterialTheme.colorScheme.surface,
                        RoundedCornerShape(8.dp)
                    )
                    .padding(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                TabButton(
                    text = "Pagar",
                    isSelected = selectedTab == "Pagar",
                    onClick = { selectedTab = "Pagar" },
                    modifier = Modifier.weight(1f)
                )
                TabButton(
                    text = "Cobrar",
                    isSelected = selectedTab == "Cobrar",
                    onClick = { selectedTab = "Cobrar" },
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Instruction text
            Text(
                text = "Escanea el código QR para realizar el pago",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            // QR Code display area
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(
                        color = Color(0xFFFEF2F2), // red-50
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    modifier = Modifier.size(200.dp),
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        AsyncImage(
                            model = "https://lh3.googleusercontent.com/aida-public/AB6AXuAwSzAMWK-po_RpEJ5pwHJq5CMvoESrnTc1HaRMPu2fKE42qkIU0vbUCnbz2-ZbRxkbd8ERLuJPE4peiUIufAPvPIyiZDHort0-PkQDHXkVr3f28Udvw0jO0B5_Nu3v4AM6_vfJJtdNFUY4-x79Ho7d8IR6qTVuWXoLOTv-oug3ehEdf5nnm8ddVYJdzQCmlOb9XsOEa_G8AAq8FiR593VuGaIfxGN-DNzeiMMqrcuYEtmZo01Sb8hvLW6hVPmcnQJ-sqer0HNZvvzm",
                            contentDescription = "Código QR de ejemplo",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Fit
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Action buttons grid
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    QRActionButton(
                        icon = Icons.Outlined.QrCodeScanner,
                        text = "Escanear QR",
                        onClick = onScanQRClick,
                        modifier = Modifier.weight(1f)
                    )
                    QRActionButton(
                        icon = Icons.Outlined.PhotoLibrary,
                        text = "Desde galería",
                        onClick = onGalleryClick,
                        modifier = Modifier.weight(1f)
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    QRActionButton(
                        icon = Icons.Outlined.Link,
                        text = "Pegar enlace",
                        onClick = onPasteLinkClick,
                        modifier = Modifier.weight(1f)
                    )
                    QRActionButton(
                        icon = Icons.Outlined.History,
                        text = "Historial",
                        onClick = onHistoryClick,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
fun TabButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(40.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Primary else Color.Transparent,
            contentColor = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp
        ),
        shape = RoundedCornerShape(6.dp)
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )
    }
}

@Composable
fun QRActionButton(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(80.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                tint = Primary,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = text,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )
        }
    }
}

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

@Preview(showBackground = true)
@Composable
fun QRCodeScreenPreview() {
    GTCAppTheme {
        QRCodeScreen()
    }
}

@Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun QRCodeScreenDarkPreview() {
    GTCAppTheme {
        QRCodeScreen()
    }
}
