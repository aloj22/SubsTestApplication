package com.example.substestapplication.data.source.local

import com.example.substestapplication.domain.Movie
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single


/**
 * Manages local storage
 */
interface LocalSource {

    /**
     * Add a movie as favorite
     */
    fun addFavoriteMovie(movie: Movie): Completable

    /**
     * Remove a movie from favorites
     */
    fun removeFavoriteMovie(movie: Movie): Completable

    /**
     * Get favorite movies
     */
    fun getFavoriteMovies(): Observable<List<Movie>>

    /**
     * Check if a movie is favorited
     */
    fun isMovieFavorited(id: Long): Single<Boolean>

}
