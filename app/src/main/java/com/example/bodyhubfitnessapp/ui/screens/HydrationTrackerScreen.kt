package com.example.bodyhubfitnessapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bodyhubfitnessapp.ui.components.BottomNavigationBar

@Composable
fun HydrationScreen(navController: NavHostController) {
    var hydrationLevel by remember { mutableIntStateOf(1221) }
    val targetHydration = 1900

    Scaffold(
        bottomBar = {
            BottomNavigationBar(selected = "Hydration", navController)
        },
        containerColor = Color.Gray
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            // Top Welcome Banner
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color(0xFF3E1D96)),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile",
                        tint = Color.White,
                        modifier = Modifier.size(50.dp)
                    )
                    Text("Welcome, my friend!", color = Color.White)
                }
            }

            // Hydration Tracker Card
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color(0xFFFF9100), RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Current Hydration", style = MaterialTheme.typography.titleMedium)

                    Box(
                        modifier = Modifier
                            .size(150.dp)
                            .padding(top = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        val progress = hydrationLevel.toFloat() / targetHydration.toFloat()
                        CircularProgressIndicator(
                            progress = progress.coerceIn(0f, 1f),
                            strokeWidth = 10.dp,
                            modifier = Modifier.fillMaxSize()
                        )
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("${(progress * 100).toInt()}%", style = MaterialTheme.typography.titleMedium)
                            Text("${hydrationLevel}ml")
                            Text("Remaining: ${targetHydration - hydrationLevel}ml", style = MaterialTheme.typography.labelSmall)
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Add Water Button
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color.Black)
                            .clickable {
                                hydrationLevel += 250
                                if (hydrationLevel > targetHydration) hydrationLevel = targetHydration
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add Water",
                            tint = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Reset Button
                    Button(
                        onClick = { hydrationLevel = 0 },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Reset", color = Color.White)
                    }
                }
            }
        }
    }
}