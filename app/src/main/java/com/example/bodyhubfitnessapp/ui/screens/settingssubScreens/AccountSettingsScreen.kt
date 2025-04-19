package com.example.bodyhubfitnessapp.ui.screens.settingssubScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountSettingsScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Account Settings") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text("Email: user@example.com")
            Spacer(modifier = Modifier.height(8.dp))
            Text("Username: fit_user123")
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { /* Add change password logic */ }) {
                Text("Change Password")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { /* Add logout logic */ }, colors = ButtonDefaults.buttonColors(Color.Red)) {
                Text("Logout")
            }
        }
    }
}