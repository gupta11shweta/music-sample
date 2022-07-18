package com.example.practicaltest.data.model

import com.google.gson.annotations.SerializedName

data class SongDto(
    @SerializedName("feed")
    val feed: SongFeedDto,
)

