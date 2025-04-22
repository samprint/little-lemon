package com.example.littlelemon

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController, modifier: Modifier = Modifier) {

    val context = LocalContext.current

    // Read login state from SharedPreferences
    val isLoggedIn =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .getBoolean(IS_LOGGED_IN_KEY, false)


    // Decide start destination based on login state
    val startDestination = if (isLoggedIn) Home.route else Onboarding.route

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Onboarding.route)  {
            Onboarding(navController)
        }
        composable(Home.route) {
            Home(navController)
        }

        composable(Profile.route) {
            Profile(navController)
        }

    }
}