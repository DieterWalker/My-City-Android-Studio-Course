package com.example.mycityandroidstudiocourses.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MailOutline
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.mycityandroidstudiocourses.R
import com.example.mycityandroidstudiocourses.data.Places

@Composable
fun MyCityPlaceDetail(
    place: Places,
    modifier: Modifier
){
    Column(modifier = modifier) {
        Image(
            painter = painterResource(place.imageRes),
            contentDescription = null,
            modifier = Modifier
                .padding(dimensionResource(R.dimen.detail_image_padding))
                .align (Alignment.CenterHorizontally)
                .clip(RoundedCornerShape(dimensionResource(R.dimen.detail_image_rounded)))
        )
        Text(
            text = stringResource(place.nameRes),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.detail_text_padding))
        )
        Text(
            text = "Địa chỉ: " + stringResource(place.addressRes),
            textAlign = TextAlign.Left,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.detail_text_padding))
        )
        Column (modifier = Modifier.verticalScroll(rememberScrollState())) {
            Text(
                text = stringResource(place.informationRes),
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.detail_text_padding))
            )
        }
    }
}

@Composable
fun MyCityPlaceDetail_ExpandedScreen(
    place: Places,
    modifier: Modifier
){
    Row(
        modifier = modifier
    ) {
        Column() {
            Image(
                painter = painterResource(place.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.detail_image_padding))
                    .clip(RoundedCornerShape(dimensionResource(R.dimen.detail_image_rounded)))
            )
        }
        Column() {
            Text(
                text = stringResource(place.nameRes),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.detail_text_padding))
            )

                Text(
                    text = "Địa chỉ: " + stringResource(place.addressRes),
                    textAlign = TextAlign.Left,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(R.dimen.detail_text_padding))
                )
            Column (modifier = Modifier.verticalScroll(rememberScrollState())) {
                Text(
                    text = stringResource(place.informationRes),
                    textAlign = TextAlign.Justify,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(R.dimen.detail_text_padding))
                )
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityDetailTopBar(
    onShare: () -> Unit,
    onPrintClick: () -> Unit,
    onBack: () -> Unit,
    modifier: Modifier,
    testPrinter: Boolean
){
    val context = LocalContext.current
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
            ) {
                IconButton(
                    onClick = onBack,
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
                Text(
                    text = "THÔNG TIN ĐỊA ĐIỂM",
                    style = MaterialTheme.typography.displayMedium,
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                  onClick = onShare
                ) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "Share"
                    )
                }
                if (testPrinter){
                    IconButton(
                        onClick = onPrintClick,
                    ){
                        Icon(
                            imageVector = Icons.Default.MailOutline,
                            contentDescription = "Print"
                        )
                    }
                }
            }
        }
    )
}