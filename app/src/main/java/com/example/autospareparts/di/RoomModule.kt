package com.example.autospareparts.di

import android.content.Context
import androidx.room.Room
import com.example.autospareparts.data.cashe.dao.MovieDao
import com.example.autospareparts.data.cashe.data_base.MovieDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

private const val MOVIE_DATABASE_NAME = "movies_database"
@Module
@InstallIn(SingletonComponent::class)
class RoomModule {
    @Provides
    fun provideDataBase(
        @ApplicationContext context: Context
    ): MovieDataBase = Room.databaseBuilder(context,MovieDataBase::class.java,MOVIE_DATABASE_NAME).build()

    @Provides
    fun provideMovieDao(
        dataBase: MovieDataBase
    ): MovieDao = dataBase.movieDao()
}