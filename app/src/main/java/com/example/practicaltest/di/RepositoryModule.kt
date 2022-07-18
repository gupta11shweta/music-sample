package com.example.practicaltest.di

import com.example.practicaltest.domain.repository.SongRepository
import com.example.practicaltest.data.repository.SongsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindSongRepository(
        songRepositoryImpl: SongsRepositoryImpl
    ): SongRepository

}