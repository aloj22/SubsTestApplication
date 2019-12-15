package com.example.substestapplication.data.source.network.impl

import com.example.substestapplication.BuildConfig
import com.example.substestapplication.data.source.network.NetworkSource

class NetworkSourceImpl(private val moviesService: MoviesService) : NetworkSource {


    companion object {
        private const val SORT_POPULARITY_DESCENDANT = "popularity.desc"
    }


    override fun getPopularMovies() = moviesService.getMovies(SORT_POPULARITY_DESCENDANT, BuildConfig.API_KEY)

}