package com.example.bodyhubfitnessapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bodyhubfitnessapp.Api.Quote
import com.example.bodyhubfitnessapp.Api.RetrofitInstance
import com.example.bodyhubfitnessapp.ApiData.foodList
import com.example.bodyhubfitnessapp.data.UserPreferences
import com.example.bodyhubfitnessapp.ui.components.BottomNavigationBar
import java.util.Calendar


@Composable
fun HomeScreen(navController: NavHostController) {
    val context = LocalContext.current
    val userPrefs = remember { UserPreferences(context) }
    val storedUser = remember { mutableStateOf("User") }
    var quote by remember { mutableStateOf<Quote?>(null) }
    var diaryText by remember { mutableStateOf("") }
    val dayOfYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
    val foodOfTheDay = remember { foodList[dayOfYear % foodList.size] }
    val randomFood = remember { foodList.random() }

    LaunchedEffect(Unit) {
        try {
            val quotes = RetrofitInstance.api.getQuotes()
            quote = quotes.firstOrNull()
        } catch (e: Exception) {
            Toast.makeText(context, "Failed to load quote", Toast.LENGTH_SHORT).show()
        }
    }

    LaunchedEffect(Unit) {
        storedUser.value = userPrefs.getUserName() ?: "User"
    }
    Scaffold(
        bottomBar = { BottomNavigationBar(selected = "Home", navController = navController) },
        containerColor = Color.Gray
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Brush.verticalGradient(listOf(Color(0xFFFF8600), Color(0xFF27187E))))
                .padding(24.dp)
        ) {
            Text(
                text = "Welcome back, ${storedUser.value}",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(24.dp))

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


                Spacer(modifier = Modifier.height(3.dp))

                Column(modifier = Modifier.padding(20.dp))

                {
                    Text(
                        text = "Inspirational Quote",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    quote?.let {
                        Text(
                            text = "\"${it.q}\"",
                            color = Color.White,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "- ${it.a}",
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    } ?: Text("Loading Quote....", style = MaterialTheme.typography.bodyLarge)

                    // ...rest of the home screen
                    //
                    //I will add a text box for daily diary
                }
            }

            Row(modifier = Modifier.padding(top = 16.dp)){
                Card(
                    modifier = Modifier
                        .width(210.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.1f)),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Meal Idea 🥗",
                            style = MaterialTheme.typography.headlineSmall,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(text = randomFood.name, color = Color.White, style = MaterialTheme.typography.bodyLarge)
                    }
                    }
                Spacer(modifier = Modifier.width(16.dp))

                    Card(
                        //modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.1f)),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "Hydration Level 🧊",
                                style = MaterialTheme.typography.headlineSmall,
                                color = Color(0xFFADD8E6),
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "Moderate",
                                color = Color.White
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(50.dp))
                Text(
                    text = "Daily Diary",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineMedium
                )
                //Spacer(modifier = Modifier.height(3.dp))

                OutlinedTextField(
                    value = diaryText,
                    onValueChange = { diaryText = it },
                    label = { Text("Today's Diary") },
                    modifier = Modifier
                        .height(250.dp)
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    textStyle = MaterialTheme.typography.bodyLarge,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.Black,
                        cursorColor = Color.Black,
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White
                    )
                )


//            Button(
//                onClick = { navController.navigate("workout") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp),
//                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF758BFD))
//            ) {
//                Icon(Icons.Default.FitnessCenter, contentDescription = null, tint = Color.White)
//                Spacer(modifier = Modifier.width(8.dp))
//                Text("Workout Plans", color = Color.White)
//            }
//
//            Button(
//                onClick = { navController.navigate("meal") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp),
//                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF758BFD))
//            ) {
//                Icon(Icons.Default.Restaurant, contentDescription = null, tint = Color.White)
//                Spacer(modifier = Modifier.width(8.dp))
//                Text("Meal Guide", color = Color.White)
//            }
//
//            Button(
//                onClick = { navController.navigate(Screen.Hydration.route) },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp),
//                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF758BFD))
//            ) {
//                Icon(Icons.Default.LocalDrink, contentDescription = null, tint = Color.White)
//                Spacer(modifier = Modifier.width(8.dp))
//                Text("Hydration Tracker", color = Color.White)
//            }
//
//            Button(
//                onClick = { navController.navigate(Screen.Profile.route) },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp),
//                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF758BFD))
//            ) {
//                Icon(Icons.Default.AccountCircle, contentDescription = null, tint = Color.White)
//                Spacer(modifier = Modifier.width(8.dp))
//                Text("Profile", color = Color.White)
//            }
//
//            Button(
//                onClick = { navController.navigate(Screen.Settings.route) },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp),
//                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF758BFD))
//            ) {
//                Icon(Icons.Default.Settings, contentDescription = null, tint = Color.White)
//                Spacer(modifier = Modifier.width(8.dp))
//                Text("Settings", color = Color.White)
//            }
            }
        }
    }
