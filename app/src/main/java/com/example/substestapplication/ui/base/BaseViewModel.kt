package com.example.substestapplication.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.substestapplication.util.SingleLiveEvent
import com.example.substestapplication.util.scheduler.Scheduler
import io.reactivex.disposables.CompositeDisposable


/**
 * Base ViewModel
 */
abstract class BaseViewModel(protected val scheduler: Scheduler) : ViewModel() {



    @Suppress("PropertyName")
    protected val _showError: SingleLiveEvent<String> = SingleLiveEvent()
    val showError: LiveData<String>
        get() = _showError



    protected val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }


    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }

}
