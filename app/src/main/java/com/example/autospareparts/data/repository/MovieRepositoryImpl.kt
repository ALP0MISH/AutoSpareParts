package com.example.autospareparts.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.autospareparts.data.models.now_playing_remote.NowPlayingResult
import com.example.autospareparts.data.models.popular_movie_remote.MovieCloud
import com.example.autospareparts.data.models.top_rated_movie_remote.TopRatedResultX
import com.example.autospareparts.data.models.upcoming_movie_remote.UpComingResult
import com.example.autospareparts.data.remote.MovieService
import com.example.autospareparts.domain.MovieRepository
import com.example.autospareparts.domain.models.MovieDomain
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService,
) : MovieRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun fetchPopularMovie(): List<MovieDomain> {
        val movieResponse = movieService.fetchPopularMovie()
        val movieRemote = movieResponse.body()
        if (movieRemote?.results?.size == null) {
            MovieDomain.unknown
        } else {
            return movieRemote.results.map {
                resultToDomain(it)
            }
        }
        return movieRemote?.results?.map { resultToDomain(it) } ?: emptyList()
    }

    override suspend fun fetchTopRatedMovie(): List<MovieDomain> {
        val movieResponse = movieService.fetchTopRatedMovie()
        val movieRemote = movieResponse.body()

        if (movieRemote?.results?.size == null) {
            MovieDomain.unknown
        } else {
            return movieRemote.results.map {
                resultToDomain(it)
            }
        }
        return movieRemote?.results?.map { resultToDomain(it) } ?: emptyList()
    }

    override suspend fun fetchNowPlayingMovie(): List<MovieDomain> {
        val movieResponse = movieService.fetchNowPlayingMovie()
        val movieRemote = movieResponse.body()

        if (movieRemote?.nowPlayingResults?.size == null) {
            MovieDomain.unknown
        } else {
            return movieRemote.nowPlayingResults.map {
                resultToDomain(it)
            }
        }
        return movieRemote?.nowPlayingResults?.map { resultToDomain(it) } ?: emptyList()
    }

    override suspend fun fetchUpComingMovie(): List<MovieDomain> {
        val movieResponse = movieService.fetchUpcomingMovie()
        val movieRemote = movieResponse.body()

        if (movieRemote?.results?.size == null) {
            MovieDomain.unknown
        } else {
            return movieRemote.results.map {
                resultToDomain(it)
            }
        }
        return movieRemote?.results?.map { resultToDomain(it) } ?: emptyList()
    }

    private fun resultToDomain(
        result: TopRatedResultX
    ): MovieDomain {
       return result.run {
            MovieDomain(
                backdropPath = backdrop_path,
                genreIds = genre_ids,
                id = id,
                originalLanguage = original_language,
                overview = overview,
                popularity = popularity,
                posterPath = poster_path ?: "",
                voteAverage = vote_average,
                voteCount = vote_count,
                title = title,
                video = true,
                adult = true,
                releaseDate = release_date,
                originalTitle = original_title
            )
        }
    }

    private fun resultToDomain(
        result: MovieCloud
    ): MovieDomain {
        return result.run {
            MovieDomain(
                backdropPath = backdrop_path,
                genreIds = genre_ids,
                id = id,
                originalLanguage = original_language,
                overview = overview,
                popularity = popularity,
                posterPath = poster_path ?: "",
                voteAverage = vote_average,
                voteCount = vote_count,
                title = title,
                video = true,
                adult = true,
                releaseDate = release_date,
                originalTitle = original_title
            )
        }
    }

    private fun resultToDomain(
        result: NowPlayingResult
    ): MovieDomain {
        return result.run {
            MovieDomain(
                backdropPath = backdrop_path,
                genreIds = genre_ids,
                id = id,
                originalLanguage = original_language,
                overview = overview,
                popularity = popularity,
                posterPath = poster_path ?: "",
                voteAverage = vote_average,
                voteCount = vote_count,
                title = title,
                video = true,
                adult = true,
                releaseDate = release_date,
                originalTitle = original_title
            )
        }
    }

    private fun resultToDomain(
        result: UpComingResult
    ): MovieDomain {
        return result.run {
            MovieDomain(
                backdropPath = backdrop_path,
                genreIds = genre_ids,
                id = id,
                originalLanguage = original_language,
                overview = overview,
                popularity = popularity,
                posterPath = poster_path ?: "",
                voteAverage = vote_average,
                voteCount = vote_count,
                title = title,
                video = true,
                adult = true,
                releaseDate = release_date,
                originalTitle = original_title
            )
        }
    }
}
