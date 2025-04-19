package com.example.bodyhubfitnessapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ExerciseTrackerScreen(
    navController: NavController,
    category: String // updated to use String directly instead of NavBackStackEntry
) {
    val allExercises = mapOf(
        "Strength" to listOf("Push Ups", "Squats", "Plank"),
        "Cardio" to listOf("Jumping Jacks", "High Knees", "Mountain Climbers"),
        "Yoga" to listOf("Downward Dog", "Tree Pose", "Cobra Pose")
    )

    val filteredExercises = allExercises[category] ?: allExercises.values.flatten()
    var selectedExercise by remember { mutableStateOf(filteredExercises.firstOrNull() ?: "") }
    var expanded by remember { mutableStateOf(false) }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color(0xFFFF9800))
                .padding(16.dp)
        ) {

            // Optional: Custom top row with a back button and title
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
                Text(
                    text = "Exercise Tracker",
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Text(
                text = "Category: $category",
                fontSize = 18.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Select Exercise",
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.clickable { expanded = true }
                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Dropdown",
                    tint = Color.White,
                    modifier = Modifier.clickable { expanded = true }
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                filteredExercises.forEach { exercise ->
                    DropdownMenuItem(
                        text = { Text(exercise) },
                        onClick = {
                            selectedExercise = exercise
                            expanded = false
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Selected: $selectedExercise",
                fontSize = 16.sp,
                color = Color.White
            )
        }
    }
}