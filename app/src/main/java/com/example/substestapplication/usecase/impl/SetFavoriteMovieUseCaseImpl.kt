package com.example.substestapplication.usecase.impl

import com.example.substestapplication.data.repository.MovieRepository
import com.example.substestapplication.domain.Movie
import com.example.substestapplication.usecase.GetPopularMoviesUseCase
import com.example.substestapplication.usecase.SetFavoriteMovieUseCase
import io.reactivex.Completable
import io.reactivex.Single

class SetFavoriteMovieUseCaseImpl(private val moviesRepository: MovieRepository) : SetFavoriteMovieUseCase {


    override fun setFavoriteMovie(favorite: Boolean, movie: Movie): Completable = moviesRepository.setFavortieMovie(favorite, movie)


}