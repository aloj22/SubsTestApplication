package com.example.substestapplication.data.source.network

import com.example.substestapplication.data.PagingApiResponse
import com.example.substestapplication.domain.Movie
import io.reactivex.Single


/**
 * Manages netword data
 */
interface NetworkSource {

    /**
     * Get popular movies
     */
    fun getPopularMovies(): Single<PagingApiResponse<Movie>>

}
