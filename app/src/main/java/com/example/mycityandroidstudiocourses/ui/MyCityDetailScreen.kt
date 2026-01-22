package com.example.mycityandroidstudiocourses.ui

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@Composable
fun MyCityDetailScreen(
    viewModel: MyCityViewModel,
    onBack: () -> Unit
){
    val uiState by viewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            MyCityDetailTopBar(
                onBack = onBack,
                modifier = Modifier
            )
        }
    ) { it ->
//        MyCityPlaceDetail()
    }
}

