package com.example.bodyhubfitnessapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bodyhubfitnessapp.navigation.Screen
import com.example.bodyhubfitnessapp.ui.components.BottomNavigationBar

@Composable
fun ProfileScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF2C1E91))
                .padding(16.dp)
        ) {
            Text(
                text = "Welcome, my friend!",
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .background(Color(0xFFFF9000))
                .padding(16.dp)
        ) {
            ProfileItem("Workout Plans") {
                navController.navigate(Screen.WorkoutPlans.route)
            }
            ProfileItem("Meal Guide") {
                navController.navigate(Screen.MealGuide.route)
            }
            ProfileItem("Hydration Tracker") {
                navController.navigate(Screen.Hydration.route)
            }
            ProfileItem("Challenge") {
                navController.navigate(Screen.Challenge.route)
            }
            ProfileItem("Skill Progress") {
                navController.navigate(Screen.SkillProgress.route)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(Color.Black)
            )
        }

        BottomNavigationBar(selected = "Profile", navController = navController)
    }
}

@Composable
fun ProfileItem(label: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable(onClick = onClick), // Add clickable modifier here
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(label)
            Icon(Icons.Default.KeyboardArrowRight, contentDescription = null)
        }
    }
}