package com.example.bodyhubfitnessapp.ui.screens.settingssubScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bodyhubfitnessapp.data.UserPreferences
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountSettingsScreen(navController: NavHostController) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val userPrefs = remember { UserPreferences(context) }
    val storedUser = remember { mutableStateOf("User") }
    val  storedEmail = remember{ mutableStateOf("Email") }
    val storedPassword = remember{mutableStateOf("password")}
    val currentPassword = remember { mutableStateOf("") }
    val newPassword = remember { mutableStateOf("") }
    val showPasswordDialog = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        storedUser.value = userPrefs.getUserName() ?: "User"
        storedEmail.value = userPrefs.getEmail() ?: "Email"
        storedPassword.value = userPrefs.getPassword() ?: "password"
    }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Account Settings") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text("Email: ${storedEmail.value}")
            Spacer(modifier = Modifier.height(8.dp))
            Text("Username: ${storedUser.value}")
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { showPasswordDialog.value = true }) {
                Text("Change Password")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { navController.navigate("login") }, colors = ButtonDefaults.buttonColors(Color.Red)) {
                Text("Logout")
            }
        }
    }

    if (showPasswordDialog.value) {
        AlertDialog(
            onDismissRequest = { showPasswordDialog.value = false },
            title = { Text(text = "Change Password") },
            text = {
                Column {
                    OutlinedTextField(
                        value = currentPassword.value,
                        onValueChange = { currentPassword.value = it },
                        label = { Text("Current Password") },
                        visualTransformation = PasswordVisualTransformation()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = newPassword.value,
                        onValueChange = { newPassword.value = it },
                        label = { Text("New Password") },
                        visualTransformation = PasswordVisualTransformation()
                    )
                }
            },
            confirmButton = {
                Button(onClick = {
                    if (currentPassword.value == storedPassword.value) {
                        coroutineScope.launch {
                            userPrefs.savePassword(newPassword.value)
                            storedPassword.value = newPassword.value
                            showPasswordDialog.value = false
                        }
                    }
                }) {
                    Text(text = "Save")
                }
            },
            dismissButton = {
                Button(onClick = { showPasswordDialog.value = false }) {
                    Text(text = "Cancel")
                }
            }
        )
    }
}