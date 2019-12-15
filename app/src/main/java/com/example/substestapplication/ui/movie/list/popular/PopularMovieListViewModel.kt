package com.example.substestapplication.ui.movie.list.popular

import com.example.substestapplication.domain.Movie
import com.example.substestapplication.ui.movie.list.base.MovieListBaseViewModel
import com.example.substestapplication.usecase.GetPopularMoviesUseCase
import com.example.substestapplication.util.scheduler.Scheduler
import io.reactivex.observers.DisposableSingleObserver

/**
 * ViewModel to display a list of popular movies
 */
class PopularMovieListViewModel(private val getPopularMoviesUseCase: GetPopularMoviesUseCase, scheduler: Scheduler)
    : MovieListBaseViewModel(scheduler) {


    init {
        getPopularMovies()
    }

    private fun getPopularMovies() {
        _showLoading.value = true
        compositeDisposable.add(getPopularMoviesUseCase.getPopularMovies()
            .observeOn(scheduler.observeOnScheduler)
            .subscribeOn(scheduler.subscribeOnScheduler)
            .subscribeWith(object : DisposableSingleObserver<List<Movie>>() {
                override fun onSuccess(t: List<Movie>) {
                    _showLoading.value = false
                    _addMovies.value = t
                }

                override fun onError(e: Throwable) {
                    _showLoading.value = false
                    _showError.value = e.localizedMessage
                }

            }))
    }

}
