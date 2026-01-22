package com.example.mycityandroidstudiocourses.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.mycityandroidstudiocourses.data.displayNameRes

@Composable
fun MyCityCategoryScreen(
    viewModel: MyCityViewModel,
    onBack: () -> Unit,
    onPlaceClick: () -> Unit
){
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            MyCityCategoryTopBar(
                onBack = onBack,
                modifier = Modifier,
                title = uiState.currentCategory
                    ?.let { stringResource(it.displayNameRes()) }
                    ?: "DANH MỤC"
            )
        }
    ) { innerPadding ->
        MyCityPlacesList(
            places = uiState.placesByCategory,
            modifier = Modifier.padding(innerPadding),
            onPlaceClick = onPlaceClick
        )
    }
}

//@Preview (showBackground = true)
//@Composable
//fun Test(){
//    MyCityCategoryScreen()
//}