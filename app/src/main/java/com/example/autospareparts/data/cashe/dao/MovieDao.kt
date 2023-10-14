package com.example.autospareparts.data.cashe.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.autospareparts.data.cashe.models.MovieDetailCache

@Dao
interface MovieDao {
        @Insert
       suspend fun addNewMovie(movie: MovieDetailCache)

        @Query("DELETE  FROM movie_table WHERE id = :movieId")
       suspend fun deleteMovieById(movieId: String)

        @Query("SELECT * FROM movie_table")
       suspend fun fetchSavedMovies():List<MovieDetailCache>
}