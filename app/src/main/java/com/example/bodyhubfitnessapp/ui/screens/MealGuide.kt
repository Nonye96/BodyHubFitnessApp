package com.example.bodyhubfitnessapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bodyhubfitnessapp.ui.DiagonalBackground
import com.example.bodyhubfitnessapp.ui.components.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealGuideScreen(navController: NavHostController) {
    val weeks = listOf("Week 1", "Week 2", "Week 3", "Week 4")
    val expandedStates = remember { weeks.associateWith { mutableStateOf(false) } }
    var selectedOption by remember { mutableStateOf("All Weeks") }
    val options = listOf("All Weeks") + weeks
    var expanded by remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(selected = "Meal", navController)
        }
    ) { paddingValues ->
        DiagonalBackground {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = "Meal Guide",
                    fontSize = 28.sp,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedTextField(
                        value = selectedOption,
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Select Week") },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                        },
                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth()
                    )

                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        options.forEach { option ->
                            DropdownMenuItem(
                                text = { Text(option) },
                                onClick = {
                                    selectedOption = option
                                    expanded = false
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                val weekData = mapOf(
                    "Week 1" to MealData(
                        "Scrambled eggs, spinach, toast, banana",
                        "Grilled chicken, brown rice, broccoli",
                        "Baked salmon, sweet potato, salad",
                        "Greek yogurt with berries, almonds"
                    ),
                    "Week 2" to MealData(
                        "Oatmeal, chia seeds, apple, boiled egg",
                        "Turkey wrap, carrot sticks",
                        "Tofu stir fry, quinoa",
                        "Protein shake, rice cakes"
                    ),
                    "Week 3" to MealData(
                        "Smoothie, muffin",
                        "Shrimp salad, grain roll",
                        "Chicken stir fry, rice",
                        "Cottage cheese, trail mix"
                    ),
                    "Week 4" to MealData(
                        "Parfait, egg",
                        "Tuna sandwich, cucumbers",
                        "Meatballs, zucchini noodles",
                        "Hummus, protein bar"
                    )
                )

                val visibleWeeks = if (selectedOption == "All Weeks") weeks else listOf(selectedOption)

                visibleWeeks.forEach { week ->
                    val isExpanded = expandedStates[week] ?: remember { mutableStateOf(false) }
                    ExpandableMealWeekCard(
                        week = week,
                        data = weekData[week]!!,
                        expanded = isExpanded.value,
                        onClick = { isExpanded.value = !isExpanded.value }
                    )
                }
            }
        }
    }
}

data class MealData(
    val breakfast: String,
    val lunch: String,
    val dinner: String,
    val snack: String
)

@Composable
fun ExpandableMealWeekCard(
    week: String,
    data: MealData,
    expanded: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = week,
                style = MaterialTheme.typography.titleMedium
            )
            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text("Breakfast: ${data.breakfast}")
                Text("Lunch: ${data.lunch}")
                Text("Dinner: ${data.dinner}")
                Text("Snack: ${data.snack}")
            }
        }
    }
}