package com.example.practicaltest.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.practicaltest.domain.model.SongData

@Database(
    entities = [SongData::class],
    version = 1
)
abstract class SongDatabase : RoomDatabase() {
    abstract val songDao: SongDao

    companion object {
        const val DATABASE_NAME = "songs_db"
    }
}