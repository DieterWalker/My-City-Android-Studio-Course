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
import com.example.mycityandroidstudiocourses.data.Places
import com.example.mycityandroidstudiocourses.ui.utils.MyCityDetailScreenType

@Composable
fun MyCityDetailScreen(
    onShare: (Places) -> Unit,
    onPrintClick: (Places) -> Unit,
    screenType: MyCityDetailScreenType,
    viewModel: MyCityViewModel,
    onBack: () -> Unit,
    testPrinter: Boolean
){
    val uiState by viewModel.uiState.collectAsState()
    val place = uiState.currentPlace ?: return

    Scaffold(
        topBar = {
            MyCityDetailTopBar(
                onShare = {onShare(place)},
                onPrintClick = { onPrintClick(place) },
                onBack = onBack,
                modifier = Modifier,
                testPrinter = testPrinter,
            )
        }
    ) { it ->
        if ( screenType == MyCityDetailScreenType.COMPACT_SCREEN)
            MyCityPlaceDetail(
                place,
                modifier = Modifier.padding(it)
            )
        else {
            MyCityPlaceDetail_ExpandedScreen(
                place,
                modifier = Modifier.padding(it)
            )
        }
    }
}

