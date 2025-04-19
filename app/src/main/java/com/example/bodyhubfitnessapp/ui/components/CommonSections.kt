package com.example.bodyhubfitnessapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderSection(title: String, icon: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF311B92)) // Dark purple
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = icon), contentDescription = null)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = title, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun BodySection(list: List<String>, icon: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFF9800)) // Orange
            .padding(16.dp)
    ) {
        list.forEach {
            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clickable { }
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(it, fontSize = 16.sp)
                    Image(painter = painterResource(id = icon), contentDescription = null)
                }
            }
        }
    }
}

@Composable
fun ChartSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Text("Graph", color = Color.White)
    }

    @Composable
    fun CommonSections(
        onHydrationClick: () -> Unit,
        onProfileClick: () -> Unit,
        onSettingsClick: () -> Unit
    ) {
        Column {
            SectionItem(title = "Hydration", onClick = onHydrationClick)
            SectionItem(title = "Profile", onClick = onProfileClick)
            SectionItem(title = "Settings", onClick = onSettingsClick)
        }
    }
}

    @Composable
    fun SectionItem(title: String, onClick: () -> Unit) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onClick() },
            colors = androidx.compose.material3.CardDefaults.cardColors(
                containerColor = Color(0xFF758BFD)
            ),
            elevation = androidx.compose.material3.CardDefaults.cardElevation(8.dp)
        ) {
            Text(
                text = title,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
