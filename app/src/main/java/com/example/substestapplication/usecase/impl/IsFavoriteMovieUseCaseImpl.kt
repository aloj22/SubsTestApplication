package com.example.substestapplication.usecase.impl

import com.example.substestapplication.data.repository.MovieRepository
import com.example.substestapplication.usecase.IsFavoriteMovieUseCase
import io.reactivex.Single



class IsFavoriteMovieUseCaseImpl(private val moviesRepository: MovieRepository) : IsFavoriteMovieUseCase {


    override fun isFavoriteMovie(id: Long): Single<Boolean> = moviesRepository.isMovieFavorite(id)


}