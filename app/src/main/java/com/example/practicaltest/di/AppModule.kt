package com.example.practicaltest.di

import android.content.Context
import androidx.room.Room
import com.example.practicaltest.BuildConfig
import com.example.practicaltest.data.database.SongDao
import com.example.practicaltest.data.database.SongDatabase
import com.example.practicaltest.data.remote.SongApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private const val URL = BuildConfig.SERVER_URL

    @Provides
    @Singleton
    fun provideNoteDatabase(@ApplicationContext appContext: Context): SongDatabase {
        return Room.databaseBuilder(
            appContext,
            SongDatabase::class.java,
            SongDatabase.DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideMyDao(database: SongDatabase): SongDao {
        return database.songDao
    }

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient =
        OkHttpClient
            .Builder()
            .connectTimeout(45, TimeUnit.SECONDS)
            .readTimeout(45, TimeUnit.SECONDS)
            .callTimeout(45, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

    @Provides
    @Singleton
    fun provideWeatherApi(
        okHttp: OkHttpClient,
    ): SongApi {
        return Retrofit.Builder()
            .client(okHttp)
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

}