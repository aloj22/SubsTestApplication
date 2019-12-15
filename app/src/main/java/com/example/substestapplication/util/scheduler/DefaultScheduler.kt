package com.example.substestapplication.util.scheduler

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DefaultScheduler : Scheduler {

    override val observeOnScheduler: io.reactivex.Scheduler = AndroidSchedulers.mainThread()

    override val subscribeOnScheduler: io.reactivex.Scheduler = Schedulers.io()

}