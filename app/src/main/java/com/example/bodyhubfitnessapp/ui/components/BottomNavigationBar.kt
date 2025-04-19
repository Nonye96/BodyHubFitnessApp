package com.example.bodyhubfitnessapp.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.navigation.NavHostController
import com.example.bodyhubfitnessapp.navigation.Screen

@Composable
fun BottomNavigationBar(selected: String, navController: NavHostController) {
    NavigationBar(containerColor = Color(0xFF888BFB)) {
        val items = listOf("Home", "Workout", "Meal", "Profile", "Setting")
        val icons = listOf(
            Icons.Default.Home,
            Icons.Default.FitnessCenter,
            Icons.Default.Restaurant,
            Icons.Default.Person,
            Icons.Default.Settings
        )
        val screenRoutes = listOf(
            Screen.Home.route,
            Screen.WorkoutPlans.route,
            Screen.MealGuide.route,
            Screen.Profile.route,
            Screen.Settings.route
        )

        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selected == item,
                onClick = {
                    navController.navigate(screenRoutes[index]) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                    }
                },
                icon = {
                    Icon(
                        imageVector = icons[index],
                        contentDescription = item
                    )
                },
                label = { Text(item) }
            )
        }
    }
}
