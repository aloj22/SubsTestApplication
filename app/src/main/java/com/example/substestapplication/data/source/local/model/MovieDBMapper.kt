package com.example.substestapplication.data.source.local.model

import com.example.substestapplication.domain.Movie
import java.util.*

class MovieDBMapper {
    
    
    fun fromMovie(movie: Movie) = MovieDB(
        movie.id,
        movie.popularity,
        movie.voteCount,
        movie.video,
        movie.posterPath,
        movie.adult,
        movie.backdropPath,
        movie.originalLanguage,
        movie.originalTitle,
        movie.title,
        movie.voteAverage,
        movie.overview,
        movie.releaseDate.time
    )
    
    fun toMovie(movieDB: MovieDB) = Movie(
        movieDB.popularity,
        movieDB.voteCount,
        movieDB.video,
        movieDB.posterPath,
        movieDB.id,
        movieDB.adult,
        movieDB.backdropPath,
        movieDB.originalLanguage,
        movieDB.originalTitle,
        movieDB.title,
        movieDB.voteAverage,
        movieDB.overview,
        Date(movieDB.releaseDateInMillis)
    )
    
}