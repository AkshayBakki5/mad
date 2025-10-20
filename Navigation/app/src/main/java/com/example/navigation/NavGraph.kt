package com.example.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "A"
    ) {
        composable("A") { ScreenA(navController) }
        composable("B") { ScreenB(navController) }
        composable("C") { ScreenC(navController) }
    }
}
