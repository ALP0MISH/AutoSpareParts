package com.example.moviesapp.data.cashe.data_base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.moviesapp.data.cashe.dao.MovieDao
import com.example.moviesapp.data.cashe.models.MovieDetailCache
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

@Database(
    entities = [MovieDetailCache::class],
    version = 1
)
@TypeConverters(MovieDataBase.Converters::class)
abstract class MovieDataBase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    object Converters{
        @TypeConverter
        fun fromString(value: String?) : List<String> {
            val listType: Type = object : TypeToken<List<String?>?>() {}.type
            return Gson().fromJson(value, listType)
        }
        @TypeConverter
        fun fromList(list: List<String?>?) : String {
            val gson= Gson()
            return gson.toJson(list)
        }
    }
}