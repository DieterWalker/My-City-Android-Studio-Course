package com.example.mycityandroidstudiocourses.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycityandroidstudiocourses.data.Category

@Composable
fun MyCityHomeScreen(){
    Scaffold(
        topBar = {
            HomeCategoryTopBar(modifier = Modifier)
        }
    ) { it ->
        HomeCategoryList(
            Category.entries,
            modifier = Modifier.padding(it)
        )
    }
}

@Preview (showBackground = true)
@Composable
fun Test(){
    MyCityHomeScreen()
}


