package com.example.substestapplication.data.source.local.impl

import com.example.substestapplication.data.source.local.LocalSource
import com.example.substestapplication.data.source.local.model.MovieDBMapper
import com.example.substestapplication.domain.Movie
import io.reactivex.*

class LocalSourceImpl(private val favoriteMoviesDao: FavoriteMoviesDao,
                      private val movieDBMapper: MovieDBMapper) : LocalSource {


    override fun addFavoriteMovie(movie: Movie): Completable = favoriteMoviesDao.insert(movieDBMapper.fromMovie(movie))

    override fun removeFavoriteMovie(movie: Movie): Completable = favoriteMoviesDao.delete(movieDBMapper.fromMovie(movie))

    override fun getFavoriteMovies(): Observable<List<Movie>> = favoriteMoviesDao.getFavsMovies().flatMap {
        Observable.fromIterable(it).map { movie ->
            movieDBMapper.toMovie(movie)
        }.toList().toObservable()
    }

    override fun isMovieFavorited(id: Long): Single<Boolean> = favoriteMoviesDao.getMovieCount(id).map { it > 0 }.onErrorReturn { false }
}