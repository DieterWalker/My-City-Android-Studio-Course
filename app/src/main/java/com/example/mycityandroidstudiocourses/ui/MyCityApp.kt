package com.example.mycityandroidstudiocourses.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MyCityApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MyCityScreen.MAIN.name
    ) {
        composable ( route = MyCityScreen.MAIN.name ) {
            MyCityHomeScreen(
                onCategoryClick = {
                    navController.navigate(MyCityScreen.PLACES.name)
                }
            )
        }

        composable (route = MyCityScreen.PLACES.name) {
            MyCityCategoryScreen()
        }

        composable (route = MyCityScreen.INFORMATION.name){
            MyCityDetailScreen()
        }
    }
}