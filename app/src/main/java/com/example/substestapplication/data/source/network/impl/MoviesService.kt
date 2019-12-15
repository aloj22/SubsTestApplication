package com.example.substestapplication.data.source.network.impl

import com.example.substestapplication.data.PagingApiResponse
import com.example.substestapplication.domain.Movie
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {

    @GET("4/discover/movie")
    fun getMovies(@Query("sort_by") sortBy: String,
                  @Query("api_key") apiKey: String): Single<PagingApiResponse<Movie>>

}
