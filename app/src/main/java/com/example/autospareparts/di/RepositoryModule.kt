package com.example.autospareparts.di

import com.example.autospareparts.data.remote.MovieService
import com.example.autospareparts.data.repository.MovieRepositoryImpl
import com.example.autospareparts.domain.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideMovieRepository(
        movieService: MovieService
    ): MovieRepository = MovieRepositoryImpl(movieService)
}