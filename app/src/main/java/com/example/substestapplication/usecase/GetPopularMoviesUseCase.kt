package com.example.substestapplication.usecase

import com.example.substestapplication.domain.Movie
import io.reactivex.Single


/**
 * Use Case that get a list of popular movies
 */
interface GetPopularMoviesUseCase {


    fun getPopularMovies(): Single<List<Movie>>

}