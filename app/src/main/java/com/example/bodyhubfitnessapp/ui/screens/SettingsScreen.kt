package com.example.bodyhubfitnessapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bodyhubfitnessapp.ui.components.BottomNavigationBar

@Composable
fun SettingsScreen(navController: NavHostController) {
    val profileGradient = Brush.verticalGradient(
        colors = listOf(Color(0xFFFFA726), Color(0xFFAB47BC)) // Same as ProfileScreen
    )

    Scaffold(
        bottomBar = { BottomNavigationBar(selected = "Setting", navController = navController) },
        containerColor = Color.Transparent
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(profileGradient)
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Settings",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(24.dp))

                SettingsOption("Account", Icons.Default.AccountCircle) {
                    navController.navigate("accountSettings")
                }

                SettingsOption("Languages", Icons.Default.Language) {
                    navController.navigate("languageSettings")
                }

                SettingsOption("Country", Icons.Default.Public) {
                    navController.navigate("countrySettings")
                }

                SettingsOption("Notifications", Icons.Default.Notifications) {
                    navController.navigate("notificationSettings")
                }

                SettingsOption("Contact Us", Icons.Default.Email) {
                    navController.navigate("contactSettings")
                }
            }
        }
    }
}

@Composable
fun SettingsOption(title: String, icon: ImageVector, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF758BFD))
    ) {
        Icon(icon, contentDescription = null, tint = Color.White)
        Spacer(modifier = Modifier.width(8.dp))
        Text(title, color = Color.White)
    }
}