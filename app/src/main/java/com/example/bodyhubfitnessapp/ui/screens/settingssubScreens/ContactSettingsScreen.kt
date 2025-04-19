package com.example.bodyhubfitnessapp.ui.screens.settingssubScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactSettingsScreen(navController: NavHostController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Contact Support") }) }) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            Text("Need help? Reach out to us:")
            Spacer(modifier = Modifier.height(8.dp))
            Text("📧 Email: support@bodyhubfitness.com")
            Spacer(modifier = Modifier.height(8.dp))
            Text("📞 Phone: +1-800-BODYHUB")
        }
    }
}