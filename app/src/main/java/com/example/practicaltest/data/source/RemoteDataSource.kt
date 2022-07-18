package com.example.practicaltest.data.source

import com.example.practicaltest.data.mappers.toSongDataMap
import com.example.practicaltest.data.remote.SongApi
import com.example.practicaltest.domain.model.SongData
import com.example.practicaltest.domain.repository.Resource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val api: SongApi,
) {
    suspend fun getSongData(): Resource<List<SongData>> {
        return try {
            val data = api.getSongData()
            Resource.Success(
                data = data.toSongDataMap()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}