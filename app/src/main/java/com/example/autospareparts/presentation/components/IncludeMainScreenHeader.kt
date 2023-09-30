package com.example.autospareparts.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.autospareparts.presentation.screens.main.MainViewModel

@Composable
fun IncludeMainScreenHeaderPreview(){
//    IncludeMainScreenHeader(
//        posterModels = {
//
//        }
//    )
}

@Composable
fun IncludeMainScreenHeader(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
//    posterModels: PosterModels
) {
    Box(
        modifier = modifier
            .width(144.dp)
            .height(210.dp)
    ) {
        //Image(painter = posterModels.imageUrl, contentDescription = null)
    }
}