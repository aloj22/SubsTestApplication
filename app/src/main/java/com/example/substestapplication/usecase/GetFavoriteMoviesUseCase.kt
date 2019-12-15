package com.example.substestapplication.usecase

import com.example.substestapplication.domain.Movie
import io.reactivex.Observable


/**
 * Use Case that get a list of favorite movies
 */
interface GetFavoriteMoviesUseCase {


    fun getFavoriteMovies(): Observable<List<Movie>>

}