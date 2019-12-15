package com.example.substestapplication.data.source.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.util.*


@Entity(tableName = MovieDB.TABLE_NAME)
data class MovieDB(
    @PrimaryKey val id: Long,
    val popularity: Double,
    val voteCount: Int,
    val video: Boolean, val posterPath: String,
    val adult: Boolean, val backdropPath: String,
    val originalLanguage: String?,
    val originalTitle: String?,
    val title: String, val voteAverage: Double,
    val overview: String,
    val releaseDateInMillis: Long
) {


    companion object {
        const val TABLE_NAME = "movie"
    }

}
