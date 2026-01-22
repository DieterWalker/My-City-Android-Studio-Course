package com.example.mycityandroidstudiocourses.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MyCityDetailScreen(
    viewModel: MyCityViewModel,
    onBack: () -> Unit
){
    val uiState by viewModel.uiState.collectAsState()
    val place = uiState.currentPlace ?: return

    Scaffold(
        topBar = {
            MyCityDetailTopBar(
                onBack = onBack,
                modifier = Modifier
            )
        }
    ) { it ->
        MyCityPlaceDetail(
            place,
            modifier = Modifier.padding(it)
        )
    }
}

