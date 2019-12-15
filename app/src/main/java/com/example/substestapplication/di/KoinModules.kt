package com.example.substestapplication.di

import com.example.substestapplication.BuildConfig
import com.example.substestapplication.data.repository.MovieRepository
import com.example.substestapplication.data.repository.impl.MovieRepositoryImpl
import com.example.substestapplication.data.source.local.LocalSource
import com.example.substestapplication.data.source.local.impl.FavoriteMoviesDao
import com.example.substestapplication.data.source.local.impl.LocalSourceImpl
import com.example.substestapplication.data.source.local.impl.MoviesDatabase
import com.example.substestapplication.data.source.local.model.MovieDBMapper
import com.example.substestapplication.data.source.network.NetworkSource
import com.example.substestapplication.data.source.network.impl.NetworkSourceImpl
import com.example.substestapplication.data.source.network.impl.WebService
import com.example.substestapplication.domain.Movie
import com.example.substestapplication.ui.movie.detail.MovieDetailViewModel
import com.example.substestapplication.ui.movie.list.favorite.FavoriteMovieListViewModel
import com.example.substestapplication.ui.movie.list.popular.PopularMovieListViewModel
import com.example.substestapplication.usecase.GetFavoriteMoviesUseCase
import com.example.substestapplication.usecase.GetPopularMoviesUseCase
import com.example.substestapplication.usecase.IsFavoriteMovieUseCase
import com.example.substestapplication.usecase.SetFavoriteMovieUseCase
import com.example.substestapplication.usecase.impl.GetFavoriteMoviesUseCaseImpl
import com.example.substestapplication.usecase.impl.GetPopularMoviesUseCaseImpl
import com.example.substestapplication.usecase.impl.IsFavoriteMovieUseCaseImpl
import com.example.substestapplication.usecase.impl.SetFavoriteMovieUseCaseImpl
import com.example.substestapplication.util.scheduler.DefaultScheduler
import com.example.substestapplication.util.scheduler.Scheduler
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object KoinModules {


    val VIEW_MODEL_MODULE = module {
        viewModel { PopularMovieListViewModel(get(), get()) }
        viewModel { (movie: Movie) -> MovieDetailViewModel(movie, get(), get(), get()) }
        viewModel { FavoriteMovieListViewModel(get(), get()) }
    }


    val USE_CASE_MODULE = module {
        factory { GetPopularMoviesUseCaseImpl(get()) as GetPopularMoviesUseCase }
        factory { GetFavoriteMoviesUseCaseImpl(get()) as GetFavoriteMoviesUseCase }
        factory { SetFavoriteMovieUseCaseImpl(get()) as SetFavoriteMovieUseCase }
        factory { IsFavoriteMovieUseCaseImpl(get()) as IsFavoriteMovieUseCase }
    }


    val DATA_MODULE = module {
        factory { MovieRepositoryImpl(get(), get()) as MovieRepository }
        factory { NetworkSourceImpl(get()) as NetworkSource }
        factory { LocalSourceImpl(get(), get()) as LocalSource }
        single { FavoriteMoviesDao.create(get()) }
        factory { MovieDBMapper() }
        single { WebService.createService(BuildConfig.API_BASE_URL) }
        single { MoviesDatabase.createInstance(androidContext()) }
    }


    val UTIL_MODULE = module {
        factory { DefaultScheduler() as Scheduler }
    }


}