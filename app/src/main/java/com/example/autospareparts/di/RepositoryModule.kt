package com.example.autospareparts.di

import com.example.autospareparts.data.cloude.MovieService
import com.example.autospareparts.data.repository.MovieRepositoryImpl
import com.example.autospareparts.domain.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
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