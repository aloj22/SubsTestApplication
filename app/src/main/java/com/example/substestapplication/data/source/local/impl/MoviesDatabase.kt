package com.example.substestapplication.data.source.local.impl

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.substestapplication.data.source.local.model.MovieDB

@Database(entities = [MovieDB::class], version = 1)
abstract class MoviesDatabase : RoomDatabase() {


    companion object {

        private const val DATABASE_NAME = "movies_database"

        fun createInstance(context: Context): MoviesDatabase? {
            return Room.databaseBuilder(context, MoviesDatabase::class.java, DATABASE_NAME).build()
        }
    }


    abstract fun favoriteMoviesDao(): FavoriteMoviesDao

}