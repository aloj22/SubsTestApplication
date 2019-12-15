package com.example.substestapplication.usecase

import com.example.substestapplication.domain.Movie
import io.reactivex.Completable

/**
 * Use Case that add or remove a movie as a favorite
 */
interface SetFavoriteMovieUseCase {

    fun setFavoriteMovie(favorite: Boolean, movie: Movie): Completable

}