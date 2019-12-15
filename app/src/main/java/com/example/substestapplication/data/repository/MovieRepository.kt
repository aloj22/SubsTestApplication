package com.example.substestapplication.data.repository

import com.example.substestapplication.domain.Movie
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single


/**
 * Repository to manage {@see Movie} data
 */
interface MovieRepository {

    /**
     * Get popular movies
     */
    fun getPopularMovies(): Single<List<Movie>>

    /**
     * Add/Remove a movie as favorite
     */
    fun setFavortieMovie(favorite: Boolean, movie: Movie): Completable

    /**
     * Get favorite movies
     */
    fun getFavortieMovies(): Observable<List<Movie>>

    /**
     * Check if a moviw is favorte
     * @param id Id of the movie
     */
    fun isMovieFavorite(id: Long): Single<Boolean>

}