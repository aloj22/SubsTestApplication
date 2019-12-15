package com.example.substestapplication.usecase.impl

import com.example.substestapplication.data.repository.MovieRepository
import com.example.substestapplication.domain.Movie
import com.example.substestapplication.usecase.GetFavoriteMoviesUseCase
import io.reactivex.Flowable
import io.reactivex.Observable

class GetFavoriteMoviesUseCaseImpl(private val moviesRepository: MovieRepository) : GetFavoriteMoviesUseCase {

    override fun getFavoriteMovies(): Observable<List<Movie>> = moviesRepository.getFavortieMovies()

}