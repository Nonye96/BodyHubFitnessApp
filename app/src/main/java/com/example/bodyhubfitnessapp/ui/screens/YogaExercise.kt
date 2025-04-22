package com.example.bodyhubfitnessapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bodyhubfitnessapp.ApiData.WorkoutExercise

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YogaExerciseBuilderScreen(navController: NavController) {
    val exercises = listOf(
        "Downward Dog",
        "Child's Pose",
        "Cobra Pose",
        "Tree Pose",
        "Warrior I",
        "Warrior II",
        "Cat-Cow",
        "Bridge Pose",
        "Seated Forward Bend",
        "Triangle Pose"
    )
    val durations = listOf(10, 15, 20, 25, 30)

    var selectedExercise by remember { mutableStateOf(exercises.first()) }
    var exerciseDropdownExpanded by remember { mutableStateOf(false) }

    var selectedDuration by remember { mutableStateOf(durations.first()) }
    var durationDropdownExpanded by remember { mutableStateOf(false) }

    val workoutList = remember { mutableStateListOf<WorkoutExercise>() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("YOGA Exercises") },
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
        }) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .padding(top = 50.dp)
                .fillMaxSize()
        ) {
            Text("Build Your Workout", style = MaterialTheme.typography.headlineSmall)

            Spacer(Modifier.height(16.dp))

            // Exercise Dropdown
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Exercise: ")
                Spacer(Modifier.width(8.dp))
                Box {
                    Text(
                        text = selectedExercise,
                        modifier = Modifier
                            .clickable { exerciseDropdownExpanded = true }
                            .padding(8.dp)
                            .background(Color.LightGray)
                    )
                    DropdownMenu(
                        expanded = exerciseDropdownExpanded,
                        onDismissRequest = { exerciseDropdownExpanded = false }
                    ) {
                        exercises.forEach {
                            DropdownMenuItem(
                                text = { Text(it) },
                                onClick = {
                                    selectedExercise = it
                                    exerciseDropdownExpanded = false
                                }
                            )
                        }
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            // Duration Dropdown
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Duration (sec): ")
                Spacer(Modifier.width(8.dp))
                Box {
                    Text(
                        text = "$selectedDuration",
                        modifier = Modifier
                            .clickable { durationDropdownExpanded = true }
                            .padding(8.dp)
                            .background(Color.LightGray)
                    )
                    DropdownMenu(
                        expanded = durationDropdownExpanded,
                        onDismissRequest = { durationDropdownExpanded = false }
                    ) {
                        durations.forEach {
                            DropdownMenuItem(
                                text = { Text("$it") },
                                onClick = {
                                    selectedDuration = it
                                    durationDropdownExpanded = false
                                }
                            )
                        }
                    }
                }
            }
            Spacer(Modifier.height(16.dp))
            Row {

                Button(onClick = {
                    workoutList.add(WorkoutExercise(selectedExercise, selectedDuration))
                }, modifier = Modifier.width(180.dp)) {
                    Text("Add to Workout")
                }

                //Spacer(Modifier.weight(1f))
                Spacer(Modifier.width(16.dp))
                Button(
                    onClick = {
                        //we are going to add logic to navigate to another page for the actual workout
                    },
                    modifier = Modifier.width(180.dp)
                ) {
                    Text("Start Workout")
                }
            }
            Spacer(Modifier.height(10.dp))

            Text("Workout List:", style = MaterialTheme.typography.titleMedium)

            LazyColumn {
                items(workoutList) { exercise ->
                    Text("- ${exercise.name}: ${exercise.duration} sec")
                }
            }
        }
    }
}