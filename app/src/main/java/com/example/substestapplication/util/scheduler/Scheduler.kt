package com.example.substestapplication.util.scheduler

interface Scheduler {

    /**
     * Scheduler to subscribe on
     */
    val subscribeOnScheduler: io.reactivex.Scheduler


    /**
     * Scheduler to observe on
     */
    val observeOnScheduler: io.reactivex.Scheduler

}