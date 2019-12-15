package com.example.substestapplication.ui.movie.list.favorite

import com.example.substestapplication.domain.Movie
import com.example.substestapplication.ui.movie.list.base.MovieListBaseViewModel
import com.example.substestapplication.usecase.GetFavoriteMoviesUseCase
import com.example.substestapplication.util.scheduler.Scheduler
import io.reactivex.observers.DisposableObserver


/**
 * ViewModel to display a list of favorite movies
 */
class FavoriteMovieListViewModel(private val getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase, scheduler: Scheduler)
    : MovieListBaseViewModel(scheduler) {


    init {
        getFavoriteMovies()
    }

    private fun getFavoriteMovies() {
        compositeDisposable.add(getFavoriteMoviesUseCase.getFavoriteMovies()
            .observeOn(scheduler.observeOnScheduler)
            .subscribeOn(scheduler.subscribeOnScheduler)
            .subscribeWith(object : DisposableObserver<List<Movie>>() {
                override fun onComplete() {

                }

                override fun onNext(t: List<Movie>) {
                    _addMovies.value = t
                    _showEmptyState.value = t.isEmpty()
                }

                override fun onError(t: Throwable) {
                    _showError.value = t.localizedMessage
                }

            }))
    }

}