package com.example.autospareparts.data.cashe.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.autospareparts.data.cashe.models.MovieDetailCache
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
        @Insert
       suspend fun addNewMovie(movie: MovieDetailCache)

        @Query("DELETE  FROM movie_table WHERE id = :movieId")
       suspend fun deleteMovieById(movieId: Int)

        @Query("SELECT * FROM movie_table")
       suspend fun fetchSavedMovies():List<MovieDetailCache>

       @Query("SELECT EXISTS(SELECT 1 FROM movie_table WHERE id = :movieId)")
       fun isMovieSave(movieId: Int): Flow<Boolean>
}