package com.example.autospareparts.di

import com.example.autospareparts.domain.use_case.FetchMovieByIdUseCase
import com.example.autospareparts.domain.use_case.FetchMovieByIdUseCaseImpl
import com.example.autospareparts.domain.use_case.FetchMoviesInteractor
import com.example.autospareparts.domain.use_case.FetchMoviesInteractorImpl
import com.example.autospareparts.domain.use_case.SearchMoviesByQueryUseCase
import com.example.autospareparts.domain.use_case.SearchMoviesByQueryUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {
    @Binds
    fun bindFetchMoviesInteractor(
        implement: FetchMoviesInteractorImpl
    ): FetchMoviesInteractor


    @Binds
    fun bindSearchMoviesByQueryUseCase(
        implement: SearchMoviesByQueryUseCaseImpl
    ): SearchMoviesByQueryUseCase

    @Binds
    fun bindFetchMovieByIdUseCase(
        implement: FetchMovieByIdUseCaseImpl
    ): FetchMovieByIdUseCase

}