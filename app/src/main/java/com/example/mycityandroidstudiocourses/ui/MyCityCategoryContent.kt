package com.example.mycityandroidstudiocourses.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mycityandroidstudiocourses.R
import com.example.mycityandroidstudiocourses.data.Places

@Composable
fun MyCityPlacesList(
    places: List<Places>,
    modifier: Modifier = Modifier,
    onPlaceClick: () -> Unit
){
    LazyColumn(modifier = modifier) {
        items(places) { place ->
            Button(
                onClick = onPlaceClick,
                shape = RoundedCornerShape(dimensionResource(R.dimen.list_button_rounded)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff66a3ff) ,
                    contentColor = Color.White ,
                ),
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.list_button_padding))
                    .fillMaxWidth()
            ){
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = painterResource(place.imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .aspectRatio(1f)
                            .clip(RoundedCornerShape(dimensionResource(R.dimen.list_button_image_rounded)))
                            .padding(
                                dimensionResource(R.dimen.list_button_image_padding)
                            ),
                            contentScale = ContentScale.Crop
                    )
                    Text(
                        text = stringResource(place.nameRes),
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityCategoryTopBar(
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
    title: String
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
                    text = title,
                    style = MaterialTheme.typography.displayLarge,
                )
            }
        }, modifier = modifier
    )
}

