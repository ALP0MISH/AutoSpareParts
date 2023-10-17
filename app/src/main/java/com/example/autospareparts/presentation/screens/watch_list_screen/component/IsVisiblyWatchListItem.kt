package com.example.autospareparts.presentation.screens.watch_list_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.autospareparts.R

@Preview
@Composable
fun IsVisiblyWatchListItemPreview() {
    MaterialTheme {
        IsVisiblyWatchListItem()
    }
}

@Composable
fun IsVisiblyWatchListItem(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 235.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = modifier.size(76.dp),
            painter = painterResource(id = R.drawable.watch_list_image),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = modifier,
            text = stringResource(id = R.string.there_is_not_movie_yet),
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.White, fontSize = 16.sp),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = modifier,
            text = stringResource(id = R.string.find_your_movie_by_type_title_categories_years_etc),
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 12.sp, color = colorResource(id = R.color.light_grey),
            ),
        )
    }
}