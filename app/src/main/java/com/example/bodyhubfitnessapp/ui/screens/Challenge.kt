package com.example.bodyhubfitnessapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bodyhubfitnessapp.R
import com.example.bodyhubfitnessapp.ui.components.BottomNavigationBar

@Composable
fun ChallengeScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(selected = "Challenge", navController = navController)
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
                Text("Challenge", color = Color.White, fontSize = 22.sp)
            }

            ChallengeItem(
                title = "Group Olympic",
                description = "Join your team for exciting fitness games!",
                imageRes = R.drawable.group_olympic_1
            )
            ChallengeItem(
                title = "Group Olympic",
                description = "Train with your team and compete.",
                imageRes = R.drawable.group_olympic_2
            )
            ChallengeItem(
                title = "Group Olympic",
                description = "Outdoor group race fun challenge!",
                imageRes = R.drawable.group_olympic_3
            )
        }
    }
}

@Composable
fun ChallengeItem(title: String, description: String, imageRes: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
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
            Column(modifier = Modifier.padding(12.dp)) {
                Text(title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}