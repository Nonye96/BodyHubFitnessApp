package com.example.bodyhubfitnessapp.ui.screens.settingssubScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationSettingsScreen(navController: NavHostController) {
    var workoutNotifications by remember { mutableStateOf(true) }
    var mealReminders by remember { mutableStateOf(false) }

    Scaffold(topBar = { TopAppBar(title = { Text("Notification Settings") }) }) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Workout Reminders")
                Spacer(Modifier.weight(1f))
                Switch(checked = workoutNotifications, onCheckedChange = { workoutNotifications = it })
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Meal Plan Alerts")
                Spacer(Modifier.weight(1f))
                Switch(checked = mealReminders, onCheckedChange = { mealReminders = it })
            }
        }
    }
}