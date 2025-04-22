package com.example.bodyhubfitnessapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bodyhubfitnessapp.R
import com.example.bodyhubfitnessapp.ui.components.BottomNavigationBar
import com.example.bodyhubfitnessapp.navigation.Screen

@Composable
fun WorkoutPlansScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(selected = "Workout", navController = navController)
        },
        containerColor = Color.Gray
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)

                .fillMaxSize()
                .background(Color(0xFFFF9100))
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF3E1D96))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Workout Plans",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(30.dp))


            WorkoutPlanItem("Strength", R.drawable.strength) {
                navController.navigate(Screen.StrengthExercise.route)
            }
            WorkoutPlanItem("Cardio", R.drawable.cardio) {
                navController.navigate(Screen.CardioExercise.route)
            }
            WorkoutPlanItem("Yoga", R.drawable.yoga) {
                navController.navigate(Screen.YOGAExercise.route)
            }
        }
    }
}

@Composable
fun WorkoutPlanItem(title: String, imageRes: Int, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .clickable { onClick() } // Use the lambda
    ) {
        Column {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black.copy(alpha = 0.5f))
                .padding(8.dp)) {
                Text(text = title, color = Color.White, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}