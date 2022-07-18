package com.example.practicaltest.data.repository

import com.example.practicaltest.data.source.LocalDataSource
import com.example.practicaltest.data.source.RemoteDataSource
import com.example.practicaltest.domain.model.SongData
import com.example.practicaltest.domain.repository.Resource
import com.example.practicaltest.domain.repository.SongRepository
import javax.inject.Inject

class SongsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : SongRepository {

    override suspend fun getSongData(): Resource<List<SongData>> {
        return if (localDataSource.isDataExist()) {
            localDataSource.getSongList()
        } else {
            when (val result = remoteDataSource.getSongData()) {
                is Resource.Success -> {
                    result.data?.let { localDataSource.insertAllSongs(it) }
                    result
                }
                is Resource.Error -> {
                    result
                }
            }
        }
    }

    override suspend fun getSongById(id: String): Resource<SongData> {
        return localDataSource.getSongById(id)
    }
}