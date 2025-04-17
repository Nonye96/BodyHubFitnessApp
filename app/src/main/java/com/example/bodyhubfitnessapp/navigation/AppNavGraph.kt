package com.example.bodyhubfitnessapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bodyhubfitnessapp.ui.screens.*

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object SignUp : Screen("signup")
    object Home : Screen("home")
}

@Composable
fun BodyHubApp(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) { SplashScreen(navController) }
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.SignUp.route) { SignUpScreen(navController) }
        composable(Screen.Home.route) { HomeScreen(navController) }

    }
}