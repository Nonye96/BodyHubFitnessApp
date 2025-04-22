package com.example.bodyhubfitnessapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bodyhubfitnessapp.ui.screens.CardioExerciseBuilderScreen
import com.example.bodyhubfitnessapp.ui.screens.ChallengeScreen
//import com.example.bodyhubfitnessapp.ui.screens.ExerciseTrackerScreen
import com.example.bodyhubfitnessapp.ui.screens.HomeScreen
import com.example.bodyhubfitnessapp.ui.screens.HydrationScreen
import com.example.bodyhubfitnessapp.ui.screens.LoginScreen
import com.example.bodyhubfitnessapp.ui.screens.MealGuideScreen
import com.example.bodyhubfitnessapp.ui.screens.ProfileScreen
import com.example.bodyhubfitnessapp.ui.screens.SettingsScreen
import com.example.bodyhubfitnessapp.ui.screens.SignUpScreen
import com.example.bodyhubfitnessapp.ui.screens.SkillProgressScreen
import com.example.bodyhubfitnessapp.ui.screens.SplashScreen
import com.example.bodyhubfitnessapp.ui.screens.StrengthExerciseBuilderScreen
import com.example.bodyhubfitnessapp.ui.screens.WorkoutPlansScreen
import com.example.bodyhubfitnessapp.ui.screens.YogaExerciseBuilderScreen
import com.example.bodyhubfitnessapp.ui.screens.settingssubScreens.AccountSettingsScreen
import com.example.bodyhubfitnessapp.ui.screens.settingssubScreens.LanguageSettingsScreen
import com.example.bodyhubfitnessapp.ui.screens.settingssubScreens.CountrySettingsScreen
import com.example.bodyhubfitnessapp.ui.screens.settingssubScreens.NotificationSettingsScreen
import com.example.bodyhubfitnessapp.ui.screens.settingssubScreens.ContactSettingsScreen


sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object SignUp : Screen("signup")
    object Home : Screen("home")
    object Hydration: Screen("hydrationScreen")
    object Exercise : Screen("exercise/{workoutType}")
    object Profile: Screen("ProfileScreen")
    object Settings: Screen("SettingsScreen")
    object WorkoutPlans: Screen("workoutPlans")
    object MealGuide: Screen("mealGuide")
    object Challenge: Screen("challengeScreen")
    object SkillProgress: Screen("skillProgress")
    object Account: Screen("accountSettings")
    object Languages: Screen("languageSettings")
    object Country: Screen("countrySettings")
    object Notification: Screen("notificationSettings")
    object Contact: Screen("contactSettings")
    object StrengthExercise: Screen("StrengthExerciseBuilderScreen")
    object YOGAExercise: Screen("YogaExerciseBuilderScreen")
    object CardioExercise: Screen("CardioExerciseBuilderScreen")
}

@Composable
fun BodyHubApp(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) { SplashScreen(navController) }
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.SignUp.route) { SignUpScreen(navController) }
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.StrengthExercise.route) { StrengthExerciseBuilderScreen(navController) }
        composable(Screen.YOGAExercise.route) { YogaExerciseBuilderScreen(navController) }
        composable(Screen.CardioExercise.route) {CardioExerciseBuilderScreen(navController) }
        composable("exercise/{workoutType}") { backStackEntry ->
            val workoutType = backStackEntry.arguments?.getString("workoutType") ?: ""
            //ExerciseTrackerScreen(navController, workoutType)
        }
        composable(Screen.Hydration.route) { HydrationScreen(navController) }
        composable(Screen.Profile.route) { ProfileScreen(navController) }
        composable(Screen.Settings.route) { SettingsScreen(navController) }
        composable(Screen.WorkoutPlans.route) { WorkoutPlansScreen(navController) }
        composable(Screen.MealGuide.route) { MealGuideScreen(navController) }
        composable(Screen.Challenge.route) { ChallengeScreen(navController) }
        composable(Screen.SkillProgress.route) { SkillProgressScreen(navController) }

        // Settings sub-pages
        composable(Screen.Account.route) { AccountSettingsScreen(navController) }
        composable(Screen.Languages.route) { LanguageSettingsScreen(navController) }
        composable(Screen.Country.route) { CountrySettingsScreen(navController) }
        composable(Screen.Notification.route) { NotificationSettingsScreen(navController) }
        composable(Screen.Contact.route) { ContactSettingsScreen(navController) }
    }
}







