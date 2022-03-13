package com.razgonyaev.rickandmortyapp.core.rx

import io.reactivex.Scheduler

interface RxSchedulers {
    fun io(): Scheduler
    fun computation(): Scheduler
    fun mainThread(): Scheduler
}