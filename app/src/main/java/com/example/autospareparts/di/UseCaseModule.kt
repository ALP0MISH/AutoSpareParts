package com.example.autospareparts.di

import com.example.autospareparts.data.repository.MovieRepositoryImpl
import com.example.autospareparts.domain.MovieRepository
import com.example.autospareparts.domain.use_case.FetchAllPopularMovies
import com.example.autospareparts.domain.use_case.FetchAllPopularMoviesImpl
import com.example.autospareparts.domain.use_case.FetchNowPlayingMovieUseCase
import com.example.autospareparts.domain.use_case.FetchNowPlayingMovieUseCaseImpl
import com.example.autospareparts.domain.use_case.FetchTopRatedMovieUseCase
import com.example.autospareparts.domain.use_case.FetchTopRatedMovieUseCaseImpl
import com.example.autospareparts.domain.use_case.FetchUpComingMovieUseCase
import com.example.autospareparts.domain.use_case.FetchUpComingMovieUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    fun provideFetchUseCase(
        repository: MovieRepository
    ):FetchAllPopularMovies = FetchAllPopularMoviesImpl(
        repository = repository
    )

    @Provides
    fun provideFetchTopRatedUseCase(
        repository: MovieRepository
    ): FetchTopRatedMovieUseCase = FetchTopRatedMovieUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideFetchNowPlayingUseCase(
        repository: MovieRepository
    ): FetchNowPlayingMovieUseCase = FetchNowPlayingMovieUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideFetchUpComingUseCase(
        repository: MovieRepository
    ): FetchUpComingMovieUseCase = FetchUpComingMovieUseCaseImpl(
        repository = repository
    )
}