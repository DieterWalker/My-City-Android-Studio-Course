package com.example.mycityandroidstudiocourses.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mycityandroidstudiocourses.R
import com.example.mycityandroidstudiocourses.data.Places

@Composable
fun MyCityPlacesList(
    places: List<Places>,
    modifier: Modifier = Modifier
){
    LazyColumn(modifier = Modifier) {
        items(places) { place ->
            Button(
                onClick = {},
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff66a3ff) ,
                    contentColor = Color.White ,
                ),
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.category_list_button_padding))
                    .fillMaxWidth()
            ){
                Text(
                    text = stringResource(place.nameRes),
                    textAlign = TextAlign.Left,
                    style = MaterialTheme.typography.displayLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            dimensionResource(R.dimen.category_list_button_text_padding)
                        )
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityCategoryTopBar(
    onBack: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()

            ){
                IconButton(
                    onClick = onBack
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null
                    )
                }
                Text(
                    text = "TEST",
                    style = MaterialTheme.typography.displayLarge,
                )
            }
        }, modifier = Modifier
    )
}

