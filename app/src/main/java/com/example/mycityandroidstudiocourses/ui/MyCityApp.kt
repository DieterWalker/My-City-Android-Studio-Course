package com.example.mycityandroidstudiocourses.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mycityandroidstudiocourses.data.Category

@Composable
fun MyCityApp() {
    val navController = rememberNavController()

    val viewModel: MyCityViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = MyCityScreen.MAIN.name
    ) {
        composable ( route = MyCityScreen.MAIN.name ) {
            MyCityHomeScreen(
                onCategoryClick = { category ->
                    viewModel.onCategorySelect(category)
                    navController.navigate(route = MyCityScreen.PLACES.name)
                }
            )
        }

        composable (route = MyCityScreen.PLACES.name) {
            MyCityCategoryScreen(
                viewModel = viewModel,
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable (route = MyCityScreen.INFORMATION.name){
            MyCityDetailScreen()
        }
    }
}