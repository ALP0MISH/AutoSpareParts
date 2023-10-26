package com.example.autospareparts.di

import com.example.autospareparts.domain.use_case.FetchAllSavedMoviesUseCase
import com.example.autospareparts.domain.use_case.FetchAllSavedMoviesUseCaseImpl
import com.example.autospareparts.domain.use_case.FetchMovieByIdUseCase
import com.example.autospareparts.domain.use_case.FetchMovieByIdUseCaseImpl
import com.example.autospareparts.domain.use_case.FetchMoviePeoplesUseCase
import com.example.autospareparts.domain.use_case.FetchMoviePeoplesUseCaseImpl
import com.example.autospareparts.domain.use_case.FetchMovieReviewsUseCase
import com.example.autospareparts.domain.use_case.FetchMovieReviewsUseCaseImpl
import com.example.autospareparts.domain.use_case.FetchMoviesInteractor
import com.example.autospareparts.domain.use_case.FetchMoviesInteractorImpl
import com.example.autospareparts.domain.use_case.IsMovieSavedUseCaseIMpl
import com.example.autospareparts.domain.use_case.IsMovieSavedUseCase
import com.example.autospareparts.domain.use_case.MovieOperatorUseCase
import com.example.autospareparts.domain.use_case.MovieOperatorUseCaseImpl
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

    @Binds
    fun bindIsMovieSavedUseCase(
        implement: IsMovieSavedUseCaseIMpl
    ): IsMovieSavedUseCase

    @Binds
    fun bindMovieOperatorUseCase(
        implement: MovieOperatorUseCaseImpl
    ): MovieOperatorUseCase

    @Binds
    fun bindFetchAllSavedMoviesUseCase(
        implement: FetchAllSavedMoviesUseCaseImpl
    ): FetchAllSavedMoviesUseCase

    @Binds
    fun bindFetchMoviePeoplesUseCase(
        implement: FetchMoviePeoplesUseCaseImpl
    ): FetchMoviePeoplesUseCase

    @Binds
    fun bindFetchMovieReviewsUseCase(
        implement: FetchMovieReviewsUseCaseImpl
    ): FetchMovieReviewsUseCase
}