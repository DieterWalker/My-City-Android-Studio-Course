package com.example.mycityandroidstudiocourses.ui

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mycityandroidstudiocourses.R
import com.example.mycityandroidstudiocourses.data.Category
import com.example.mycityandroidstudiocourses.printer.SunmiPrinterManager
import com.example.mycityandroidstudiocourses.ui.utils.MyCityDetailScreenType

@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
) {
    val navController = rememberNavController()

    val viewModel: MyCityViewModel = viewModel()
    val screenType: MyCityDetailScreenType
    /* Tạo hàm gọi máy in */
    var testPrinter by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val printerManager = remember {
        SunmiPrinterManager(context)
    }

    LaunchedEffect(Unit) {
        printerManager.init { hasPrinter ->
            if (hasPrinter) {
                testPrinter = true
            } else {
                testPrinter = false
            }
        }
    }


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
                onShare = { place ->
                    val link = context.getString(place.linkRes)
                    val uri = Uri.parse(link)

                    val intent = Intent(Intent.ACTION_VIEW, uri).apply {
                        setPackage("com.google.android.apps.maps")
                    }

                    try {
                        context.startActivity(intent)
                    } catch (e: Exception) {
                        // Nếu không có Google Maps thì mở bằng app mặc định
                        val fallback = Intent(Intent.ACTION_VIEW, uri)
                        context.startActivity(fallback)
                    }
                },
                onPrintClick = { place ->
                    if (testPrinter) {
                        val name = context.getString(place.nameRes)
                        val address = context.getString(place.addressRes)
                        val info = context.getString(place.informationRes)
                        val link = context.getString(place.linkRes)
                        val image = BitmapFactory.decodeResource(
                            context.resources,
                            place.imageRes
                        )
                        printerManager.printTest(name, address, info, link, image)
                    } else {
                        Toast.makeText(
                            context,
                            "Không có máy in",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                screenType = screenType,
                viewModel = viewModel,
                onBack = {
                    navController.popBackStack()
                },
                testPrinter = testPrinter
            )
        }
    }
}