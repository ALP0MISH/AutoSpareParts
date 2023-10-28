package com.example.moviesapp.di

import com.example.moviesapp.data.repository.MovieRepositoryImpl
import com.example.moviesapp.domain.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
   @Binds
   fun bindMovieRepository(
       implement: MovieRepositoryImpl
   ): MovieRepository
}