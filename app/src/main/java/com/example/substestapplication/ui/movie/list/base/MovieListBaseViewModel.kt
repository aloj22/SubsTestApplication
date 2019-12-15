package com.example.substestapplication.ui.movie.list.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.substestapplication.domain.Movie
import com.example.substestapplication.ui.base.BaseViewModel
import com.example.substestapplication.util.SingleLiveEvent
import com.example.substestapplication.util.scheduler.Scheduler


/**
 * Base view model to display a lis od movies
 */
abstract class MovieListBaseViewModel(scheduler: Scheduler) : BaseViewModel(scheduler) {


    protected val _addMovies: SingleLiveEvent<List<Movie>> = SingleLiveEvent()
    val addMovies: LiveData<List<Movie>>
        get() = _addMovies

    protected val _showEmptyState: MutableLiveData<Boolean> = MutableLiveData()
    val showEmptyState: LiveData<Boolean>
        get() = _showEmptyState

    protected val _showLoading: MutableLiveData<Boolean> = MutableLiveData()
    val showLoading: LiveData<Boolean>
        get() = _showLoading

}
