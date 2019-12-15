package com.example.substestapplication.ui.movie.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.substestapplication.domain.Movie
import com.example.substestapplication.ui.base.BaseViewModel
import com.example.substestapplication.usecase.IsFavoriteMovieUseCase
import com.example.substestapplication.usecase.SetFavoriteMovieUseCase
import com.example.substestapplication.util.scheduler.Scheduler
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver
import java.util.*


/**
 * ViewModel that displays movie detail
 */
class MovieDetailViewModel(private val movie: Movie, private val setFavoriteMovieUseCase: SetFavoriteMovieUseCase,
                           private val isFavoriteMovieUseCase: IsFavoriteMovieUseCase, scheduler: Scheduler) : BaseViewModel(scheduler) {


    private val _title: MutableLiveData<String> = MutableLiveData()
    val title: LiveData<String>
        get() = _title

    private val _posterPath: MutableLiveData<String> = MutableLiveData()
    val posterPath: LiveData<String>
        get() = _posterPath

    private val _backdropPath: MutableLiveData<String> = MutableLiveData()
    val backdropPath: LiveData<String>
        get() = _backdropPath

    private val _overview: MutableLiveData<String> = MutableLiveData()
    val overview: LiveData<String>
        get() = _overview

    private val _voteAverage: MutableLiveData<Double> = MutableLiveData()
    val voteAverage: LiveData<Double>
        get() = _voteAverage

    private val _popularity: MutableLiveData<Double> = MutableLiveData()
    val popularity: LiveData<Double>
        get() = _popularity

    private val _releaseDate: MutableLiveData<Date> = MutableLiveData()
    val releaseDate: LiveData<Date>
        get() = _releaseDate




    private val _showMovieFavorite: MutableLiveData<Boolean> = MutableLiveData()
    val showMovieFavorite: MutableLiveData<Boolean>
        get() = _showMovieFavorite


    init {
        setViewParams()
        chekIsMovieFav()
    }


    fun onFavClicked() {
        setMovieFavorite(!isMovieFavoriteIntenal())
    }

    private fun setViewParams() {
        _title.value = movie.title
        _posterPath.value = movie.posterPath
        _backdropPath.value = movie.backdropPath
        _overview.value = movie.overview
        _voteAverage.value = movie.voteAverage
        _popularity.value = movie.popularity
        _releaseDate.value = movie.releaseDate
    }

    private fun chekIsMovieFav() {
        compositeDisposable.add(isFavoriteMovieUseCase.isFavoriteMovie((movie.id))
            .observeOn(scheduler.observeOnScheduler)
            .subscribeOn(scheduler.subscribeOnScheduler)
            .subscribeWith(object : DisposableSingleObserver<Boolean>() {
                override fun onSuccess(isFavorite: Boolean) {
                    showMovieFavorite.value = isFavorite
                }

                override fun onError(e: Throwable) {
                    _showError.value = e.localizedMessage
                }

            }))
    }

    private fun setMovieFavorite(favorite: Boolean) {
        compositeDisposable.add(setFavoriteMovieUseCase.setFavoriteMovie(favorite, movie)
            .observeOn(scheduler.observeOnScheduler)
            .subscribeOn(scheduler.subscribeOnScheduler)
            .subscribeWith(object : DisposableCompletableObserver() {
                override fun onComplete() {
                    showMovieFavorite.value = favorite
                }

                override fun onError(e: Throwable) {
                    showMovieFavorite.value = !favorite
                    _showError.value = e.localizedMessage
                }

            }))
    }

    private fun isMovieFavoriteIntenal(): Boolean = showMovieFavorite.value ?: false


}