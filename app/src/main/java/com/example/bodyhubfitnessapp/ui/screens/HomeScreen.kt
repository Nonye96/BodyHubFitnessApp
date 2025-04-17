package com.example.bodyhubfitnessapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.LocalDrink
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFFFF8600), Color(0xFF27187E))))
            .padding(24.dp)
    ) {
        // Welcome Header
        Text(
            text = "Welcome back, Alex 💪",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Progress Section
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.1f)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "PROGRESS",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Weekly Goal Completion",
                    color = Color.White
                )

                LinearProgressIndicator(
                    progress = 0.6f,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(12.dp),
                    color = Color(0xFFAEB8FE),
                    trackColor = Color.White.copy(alpha = 0.3f)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Current Streak: 4 Days 🔥",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Action Buttons
        Button(
            onClick = { navController.navigate("workoutPlans") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF758BFD))
        ) {
            Icon(Icons.Default.FitnessCenter, contentDescription = null, tint = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Workout Plans", color = Color.White)
        }

        Button(
            onClick = { navController.navigate("mealGuide") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF758BFD))
        ) {
            Icon(Icons.Default.Restaurant, contentDescription = null, tint = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Meal Guide", color = Color.White)
        }

        Button(
            onClick = { navController.navigate("hydration") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF758BFD))
        ) {
            Icon(Icons.Default.LocalDrink, contentDescription = null, tint = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Hydration Tracker", color = Color.White)
        }
    }
}