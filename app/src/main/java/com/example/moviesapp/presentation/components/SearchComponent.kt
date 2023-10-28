package com.example.moviesapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviesapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    navigateToSearchScreen: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        modifier = modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth()
            .clip(CircleShape)
            .clickable { navigateToSearchScreen() },
        value = value,
        onValueChange = onValueChange,
        textStyle = MaterialTheme.typography.bodyMedium.copy(
            fontSize = 20.sp
        ),
        shape = RoundedCornerShape(16.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null,
                tint = Color.White
            )
        },
        enabled = false,
        placeholder = {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically),
                    text = stringResource(id = R.string.start_search),
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = colorResource(id = R.color.search_background),
            unfocusedIndicatorColor = colorResource(id = R.color.search_background),
            cursorColor = colorResource(id = R.color.search_background),
            containerColor = colorResource(id = R.color.search_background)
        )
    )
}

@Preview
@Composable
fun SearchTextFieldPreview() {
    MaterialTheme {
        SearchTextField(value = "",
            onValueChange = {},
            navigateToSearchScreen = {}
        )
    }
}