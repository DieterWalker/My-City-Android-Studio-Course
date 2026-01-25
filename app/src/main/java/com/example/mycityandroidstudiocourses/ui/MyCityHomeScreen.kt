package com.example.mycityandroidstudiocourses.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mycityandroidstudiocourses.data.Category

@Composable
fun MyCityHomeScreen(
    onCategoryClick: (Category) -> Unit
){
    Scaffold(
        topBar = {
            HomeCategoryTopBar(
                modifier = Modifier
            )
        }
    ) { it ->
        Column (
            modifier = Modifier
        ){
            HomeCategoryList(
                Category.entries,
                onCategoryClick = onCategoryClick,
                modifier = Modifier.padding(it)
            )
        }
    }
}


