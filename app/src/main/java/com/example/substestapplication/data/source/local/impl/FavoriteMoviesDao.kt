package com.example.substestapplication.data.source.local.impl

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.substestapplication.data.source.local.model.MovieDB
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single


@Dao
interface FavoriteMoviesDao {

    companion object {
        fun create(moviesDatabase: MoviesDatabase) : FavoriteMoviesDao = moviesDatabase.favoriteMoviesDao()
    }

    @Insert
    fun insert(movie: MovieDB): Completable


    @Delete
    fun delete(movie: MovieDB): Completable


    @Query("SELECT COUNT(*) FROM ${MovieDB.TABLE_NAME} WHERE id LIKE :id")
    fun getMovieCount(id: Long): Single<Int>


    @Query("SELECT * FROM ${MovieDB.TABLE_NAME}")
    fun getFavsMovies(): Observable<List<MovieDB>>

}