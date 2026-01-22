package com.example.mycityandroidstudiocourses.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycityandroidstudiocourses.data.Category

@Composable
fun MyCityCategoryScreen(
    viewModel: MyCityViewModel,
    onBack:  () -> Unit
){
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            MyCityCategoryTopBar(
                onBack = onBack,
                modifier = Modifier
            )
        }
    ) { innerPadding ->
        MyCityPlacesList(
            places = uiState.placesByCategory,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

//@Preview (showBackground = true)
//@Composable
//fun Test(){
//    MyCityCategoryScreen()
//}