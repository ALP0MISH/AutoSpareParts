package com.example.autospareparts.presentation.models

data class TextTypeUi(
    val title: String,
    val type: FetchType,
){
    companion object{
        fun getAllTextType(): List<TextTypeUi> = listOf(
            TextTypeUi(title = "Popular", type = FetchType.POPULAR),
            TextTypeUi(title = "Now Playing", type = FetchType.NOW_PLAYING),
            TextTypeUi(title = "Upcoming", type = FetchType.UP_COMING),
            TextTypeUi(title = "Top Rated", type = FetchType.TOP_RATED),
        )
    }
}