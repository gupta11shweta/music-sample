package com.example.practicaltest.data.mappers

import com.example.practicaltest.data.model.SongDto
import com.example.practicaltest.domain.model.SongData

fun SongDto.toSongDataMap(): List<SongData> {
    return feed.songs.map {
        SongData(
            id = it.songIdDto.attributes.id,
            imageUrl = it.images[2].imageUrl,
            title = it.title.name,
            link = it.links[1].attributes.href
        )
    }
}