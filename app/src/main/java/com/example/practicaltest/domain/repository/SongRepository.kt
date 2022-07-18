package com.example.practicaltest.domain.repository

import com.example.practicaltest.domain.model.SongData

interface SongRepository {

    suspend fun getSongData(): Resource<List<SongData>>

    suspend fun getSongById(id: String): Resource<SongData>
}