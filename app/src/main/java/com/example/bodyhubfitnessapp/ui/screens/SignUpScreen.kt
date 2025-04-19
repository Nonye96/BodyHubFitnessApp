package com.example.bodyhubfitnessapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bodyhubfitnessapp.data.UserPreferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.compose.ui.platform.LocalContext
import com.example.bodyhubfitnessapp.ui.DiagonalBackground

@Composable
fun SignUpScreen(navController: NavHostController) {
    val context = LocalContext.current
    val userPrefs = remember { UserPreferences(context) }

    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    DiagonalBackground {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(top = 120.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "CREATE ACCOUNT",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFF8600)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    //textColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.Black,
                    cursorColor = Color.Black,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    //textColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.Black,
                    cursorColor = Color.Black,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    //textColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.Black,
                    cursorColor = Color.Black,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    CoroutineScope(Dispatchers.IO).launch {
                        userPrefs.saveCredentials(email,username,password)
                    }
                    navController.navigate("home")
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF758BFD))
            ) {
                Text("Sign Up", color = Color.White)
            }
            TextButton(onClick = { navController.navigate("login") }) {
                Text("Already have an account? Log In", color = Color.White)
            }
        }
    }
}
}