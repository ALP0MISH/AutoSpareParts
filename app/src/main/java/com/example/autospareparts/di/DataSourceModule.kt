package com.example.autospareparts.di

import com.example.autospareparts.data.cashe.dao.MovieDao
import com.example.autospareparts.data.cashe.source.MovieCacheDataSource
import com.example.autospareparts.data.cashe.source.MovieCacheDataSourceImpl
import com.example.autospareparts.data.cloude.MovieService
import com.example.autospareparts.data.cloude.source.MovieCloudDataSource
import com.example.autospareparts.data.cloude.source.MovieCloudDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {
    @Provides
    fun provideMovieCacheDataSource(
        movieDao: MovieDao
    ): MovieCacheDataSource = MovieCacheDataSourceImpl(movieDao)

    @Provides
    fun provideMovieCloudDataSource(
        movieService: MovieService
    ): MovieCloudDataSource = MovieCloudDataSourceImpl(movieService)
}