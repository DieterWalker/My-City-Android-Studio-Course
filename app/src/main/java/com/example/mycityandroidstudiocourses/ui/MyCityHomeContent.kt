package com.example.mycityandroidstudiocourses.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycityandroidstudiocourses.R
import com.example.mycityandroidstudiocourses.data.Category


@Composable
fun HomeCategoryList(
    categories: List<Category>,
    onCategoryClick: (Category) -> Unit,
    modifier: Modifier = Modifier,

    ){
    LazyColumn(modifier = modifier){
        items(categories) { category ->
            Button(
                onClick = {onCategoryClick(category)},
                shape = RoundedCornerShape(dimensionResource(R.dimen.list_button_rounded)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff66a3ff) ,
                    contentColor = Color.White ,
                ),
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.list_button_padding))
                    .fillMaxWidth()
            ){
                Text(
                    text = category.name,
                    textAlign = TextAlign.Left,
                    style = MaterialTheme.typography.displayLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            dimensionResource(R.dimen.list_button_text_padding)
                        )
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeCategoryTopBar(modifier: Modifier){
    TopAppBar(
        title = {
            Text(
                text = "THÀNH PHỐ HỒ CHÍ MINH",
                style = MaterialTheme.typography.displayLarge,
                modifier = modifier
            )
        },
        modifier = modifier
    )
}


