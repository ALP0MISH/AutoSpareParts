package com.example.moviesapp.di

import com.example.moviesapp.data.cashe.dao.MovieDao
import com.example.moviesapp.data.cashe.source.MovieCacheDataSource
import com.example.moviesapp.data.cashe.source.MovieCacheDataSourceImpl
import com.example.moviesapp.data.cloude.MovieService
import com.example.moviesapp.data.cloude.source.MovieCloudDataSource
import com.example.moviesapp.data.cloude.source.MovieCloudDataSourceImpl
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