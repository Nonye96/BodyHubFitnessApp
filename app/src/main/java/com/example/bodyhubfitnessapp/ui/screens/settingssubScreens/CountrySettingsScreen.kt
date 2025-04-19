package com.example.bodyhubfitnessapp.ui.screens.settingssubScreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountrySettingsScreen(navController: NavHostController) {
    val countries = listOf("USA", "UK", "Canada", "Germany", "India")
    var selected by remember { mutableStateOf(countries[0]) }

    Scaffold(topBar = { TopAppBar(title = { Text("Country Settings") }) }) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            countries.forEach { country ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { selected = country }
                        .padding(12.dp)
                ) {
                    RadioButton(
                        selected = selected == country,
                        onClick = { selected = country }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(country)
                }
            }
        }
    }
}