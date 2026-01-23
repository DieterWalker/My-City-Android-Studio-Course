package com.example.mycityandroidstudiocourses.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mycityandroidstudiocourses.data.Category
import com.example.mycityandroidstudiocourses.ui.utils.MyCityDetailScreenType

@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
) {
    val navController = rememberNavController()

    val viewModel: MyCityViewModel = viewModel()
    val screenType: MyCityDetailScreenType
    when (windowSize){
        WindowWidthSizeClass.Compact -> {
            screenType = MyCityDetailScreenType.COMPACT_SCREEN
        }
        WindowWidthSizeClass.Medium -> {
            screenType = MyCityDetailScreenType.MEDIUM_EXPANDED_SCREEN
        }
        WindowWidthSizeClass.Expanded -> {
            screenType = MyCityDetailScreenType.MEDIUM_EXPANDED_SCREEN
        }
        else -> {
            screenType = MyCityDetailScreenType.COMPACT_SCREEN
        }
    }
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
                },
                onPlaceClick = { place ->
                    viewModel.onPlaceSelect(place)
                    navController.navigate(route = MyCityScreen.INFORMATION.name)
                }
            )
        }

        composable (route = MyCityScreen.INFORMATION.name){
            MyCityDetailScreen(
                screenType = screenType,
                viewModel = viewModel,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}