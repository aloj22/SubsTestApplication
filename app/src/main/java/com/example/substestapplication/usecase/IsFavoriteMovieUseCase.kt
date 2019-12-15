package com.example.substestapplication.usecase

import io.reactivex.Single


/**
 * Use Case that checks if a movie is favorite
 */
interface IsFavoriteMovieUseCase {

    fun isFavoriteMovie(id: Long): Single<Boolean>

}