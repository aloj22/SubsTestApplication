package com.example.substestapplication.usecase.impl

import com.example.substestapplication.data.repository.MovieRepository
import com.example.substestapplication.domain.Movie
import com.example.substestapplication.usecase.GetPopularMoviesUseCase
import io.reactivex.Single

class GetPopularMoviesUseCaseImpl(private val moviesRepository: MovieRepository) : GetPopularMoviesUseCase {

    override fun getPopularMovies(): Single<List<Movie>>  = moviesRepository.getPopularMovies()

}