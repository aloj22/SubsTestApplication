package com.example.substestapplication.data.repository.impl

import com.example.substestapplication.data.repository.MovieRepository
import com.example.substestapplication.data.source.local.LocalSource
import com.example.substestapplication.data.source.network.NetworkSource
import com.example.substestapplication.domain.Movie
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

class MovieRepositoryImpl(private val networkSource: NetworkSource, private val localSource: LocalSource) : MovieRepository {



    override fun getPopularMovies() = networkSource.getPopularMovies().map {
        it.results
    }

    override fun getFavortieMovies(): Observable<List<Movie>> = localSource.getFavoriteMovies()


    override fun setFavortieMovie(favorite: Boolean, movie: Movie): Completable = if (favorite) {
        localSource.addFavoriteMovie(movie)
    } else {
        localSource.removeFavoriteMovie(movie)
    }

    override fun isMovieFavorite(id: Long): Single<Boolean> = localSource.isMovieFavorited(id)
}